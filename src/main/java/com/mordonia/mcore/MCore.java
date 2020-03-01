package com.mordonia.mcore;

import com.mordonia.mcore.mchat.util.channelData.ChatChannelDataManager;
import com.mordonia.mcore.mchat.util.kingdomData.KingdomData;
import com.mordonia.mcore.mchat.util.kingdomData.KingdomDataManager;
import com.mordonia.mcore.mchat.util.playerData.FileConfig;
import com.mordonia.mcore.mchat.util.playerData.PlayerChatDataManager;
import com.mordonia.mcore.ms.util.TicketDataManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCore extends JavaPlugin {
   public Boolean mcoreEnabled = false;
   public PlayerChatDataManager playerChatDataManager;
   public KingdomDataManager kingdomDataManager;
   public MySQLConnection mySQLConnection;
   public ChatChannelDataManager chatChannelDataManager;
   public TicketDataManager ticketDataManager;

    @Override
    public void onEnable() {
    mcoreEnabled = true;
    startUP();
    loadConfigs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void startUP(){
        mySQLConnection = new MySQLConnection();
        playerChatDataManager = new PlayerChatDataManager(mySQLConnection);
        kingdomDataManager = new KingdomDataManager(mySQLConnection);
        chatChannelDataManager = new ChatChannelDataManager(mySQLConnection);
        ticketDataManager = new TicketDataManager(mySQLConnection);
        kingdomDataManager.load();
        chatChannelDataManager.loadChannels();

    }

    public void loadConfigs(){
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        FileConfig.createFile();
    }
}
