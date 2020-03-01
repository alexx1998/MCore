package com.mordonia.mcore.ms.util;
import com.mordonia.mcore.MCore;
import com.mordonia.mcore.MySQLConnection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class TicketDataManager {
    private MySQLConnection connection;
    private JavaPlugin plugin = MCore.getProvidingPlugin(MCore.class);
    public HashMap<Integer, TicketData> dataMap = new HashMap<>();

    public TicketDataManager(MySQLConnection connection){
        this.connection = connection;
    }

    public void loadTickets() {
        try (PreparedStatement pr = connection.getConnection().prepareStatement("SELECT * FROM ticket_data")) {
            ResultSet rs = pr.executeQuery();
            if(rs == null){
                return;
            }
            while (rs.next()) {
                Integer id = rs.getInt("id");
                if (!dataMap.containsKey(id)) {
                    UUID player = UUID.fromString(rs.getString("player"));
                    String issue = rs.getString("issues");
                    String status = rs.getString("status");
                    String name = rs.getString("name");
                    dataMap.put(id, new TicketData(id, player, issue, status, null, name));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

