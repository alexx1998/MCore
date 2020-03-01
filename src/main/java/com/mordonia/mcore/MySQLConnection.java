package com.mordonia.mcore;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements MySQLConnectionProvider {

    JavaPlugin plugin = MCore.getProvidingPlugin(MCore.class);
    String host, database, username, password;
    int port;
    @Override
    public Connection openConnection() throws SQLException {

        host = plugin.getConfig().getString("SQL.host");
        database = plugin.getConfig().getString("SQL.database");
        username = plugin.getConfig().getString("SQL.username");
        password = plugin.getConfig().getString("SQL.password");
        port = plugin.getConfig().getInt("SQL.port");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" +  this.host + ":" + this.port + "/" + this.database, this.username, this.password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.openConnection();
    }
}
