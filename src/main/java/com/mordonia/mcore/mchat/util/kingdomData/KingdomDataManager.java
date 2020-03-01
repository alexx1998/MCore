package com.mordonia.mcore.mchat.util.kingdomData;

import com.mordonia.mcore.MCore;
import com.mordonia.mcore.MySQLConnection;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class KingdomDataManager {

    private JavaPlugin plugin = MCore.getProvidingPlugin(MCore.class);
    private MySQLConnection connection;
    public Map<String , KingdomData> dataMap = new HashMap<>();


    public KingdomDataManager(MySQLConnection connection){
        this.connection = connection;

    }

    public  void load(){
        try(PreparedStatement pr = connection.getConnection().prepareStatement("SELECT * FROM kingdom_data")){
            ResultSet rs = pr.executeQuery();

            while(rs.next()){
                String name = rs.getString("name");
                String color = rs.getString("color");
                dataMap.put(name, new KingdomData(name, color));           }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  KingdomData remove(String name){
       return this.dataMap.remove(name);
    }
}
