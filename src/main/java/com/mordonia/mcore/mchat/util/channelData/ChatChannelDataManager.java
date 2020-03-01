package com.mordonia.mcore.mchat.util.channelData;

import com.mordonia.mcore.MCore;
import com.mordonia.mcore.MySQLConnection;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ChatChannelDataManager {
    private JavaPlugin plugin = MCore.getProvidingPlugin(MCore.class);
    private MySQLConnection connection;
    public Map<String, ChatChannelData> dataMap = new HashMap<>();


    public ChatChannelDataManager(MySQLConnection connection){
        this.connection = connection;
    }

    public void loadChannels(){
        try(PreparedStatement pr = connection.getConnection().prepareStatement("SELECT * FROM channels_data")) {
            ResultSet resultSet = pr.executeQuery();

            while(resultSet.next()){
                String prefix = resultSet.getString("prefix");
                String name = resultSet.getString("name");
                String color = resultSet.getString("color");
                Integer radius = resultSet.getInt("radius");
                String permission = resultSet.getString("permission");

                dataMap.put(prefix, new ChatChannelData(prefix, name, color, radius, permission));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }



}
