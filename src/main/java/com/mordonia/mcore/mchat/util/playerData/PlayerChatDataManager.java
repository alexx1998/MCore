package com.mordonia.mcore.mchat.util.playerData;


import com.mordonia.mcore.MCore;
import com.mordonia.mcore.MySQLConnection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PlayerChatDataManager {
    private JavaPlugin plugin = MCore.getProvidingPlugin(MCore.class);

    private Map<Player, PlayerChatData> dataMap = new IdentityHashMap<>();
    private MySQLConnection mySQLConnection;
    private boolean ticket;
    private List<String> LastRandNames = FileConfig.getLastNamesCfg().getStringList("lastnames.names");


    public PlayerChatDataManager(MySQLConnection conn){
        this.mySQLConnection = conn;
    }

    public PlayerChatData get(Player player){
        return this.dataMap.computeIfAbsent(player, p -> this.load(p.getUniqueId()));
    }

    public PlayerChatData load(UUID uniqueId) {
        try(PreparedStatement pr = mySQLConnection.getConnection().prepareStatement("SELECT * FROM player WHERE uuid=?")){
            pr.setString(1, uniqueId.toString());
            ResultSet result = pr.executeQuery();
            if(result.next()){
                return new PlayerChatData(result.getString("firstname"), result.getString("lastname"), result.getString("kingdom"), result.getString("chatcolor"), result.getBoolean("global"), result.getBoolean("local"), result.getBoolean("kingdom_chat"), result.getBoolean("market"), result.getBoolean("staff"), result.getBoolean("ticket"), result.getString("rank1"), result.getString("rank2"));
            }
            else{
                PreparedStatement pr2 = mySQLConnection.getConnection().prepareStatement("INSERT INTO player (uuid, firstname, lastname, kingdom, chatcolor, rank1, rank2) VALUES (?, ?, ?, ?, ?, ?,?)");

                int randNum = new Random().nextInt(LastRandNames.size());
                String lnl = LastRandNames.get(randNum);

                pr2.setString(1, uniqueId.toString());
                pr2.setString(2, "Unnamed");
                pr2.setString(3, lnl);
                pr2.setString(4, "Nomad");
                pr2.setString(5, "&f");
                pr2.setString(6, "N/A");
                pr2.setString(7, "N/A");
                pr2.executeUpdate();

                PreparedStatement pr3 = mySQLConnection.getConnection().prepareStatement("SELECT * FROM player WHERE uuid=?");
                pr3.setString(1, uniqueId.toString());
                ResultSet rs = pr3.executeQuery();
                if(rs.next()) {
                    return new PlayerChatData(result.getString("firstname"), result.getString("lastname"), result.getString("kingdom"), result.getString("chatcolor"), result.getBoolean("global"), result.getBoolean("local"), result.getBoolean("kingdom_chat"), result.getBoolean("market"), result.getBoolean("staff"), result.getBoolean("ticket"), result.getString("rank1"), result.getString("rank2"));

                }
            }

        }
        catch (SQLException e){
            System.out.println("[MCore] The result set was empty! Creating new player");
        }
        return null;
    }

    public PlayerChatData remove(Player player){
        return this.dataMap.remove(player);
    }



    public boolean isTicket(Player player) {
        try(PreparedStatement pr = mySQLConnection.getConnection().prepareStatement("SELECT ticket FROM player WHERE uuid=?")){
            pr.setString(1, player.getUniqueId().toString());
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                ticket = rs.getBoolean("ticket");
                return this.ticket;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.ticket;
    }


}
