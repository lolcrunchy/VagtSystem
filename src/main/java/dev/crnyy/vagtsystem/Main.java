package dev.crnyy.vagtsystem;

import com.earth2me.essentials.Essentials;
import dev.crnyy.vagtsystem.commands.VagtCommand;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.signs.HealSign;
import dev.crnyy.vagtsystem.plugins.vagtbuffs.VagtBuffs;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.SignManager;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Data;
import dev.crnyy.vagtsystem.placeholders.PlaceholderAPI;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.repair.Repair;
import dev.crnyy.vagtsystem.plugins.vagtchat.VagtChat;
import dev.crnyy.vagtsystem.plugins.vagtchat.VagtChatCommand;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsCommand;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.a.AVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.b.BVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.a.AVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.a.AVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b.BVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.b.BVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantItems;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.c.CVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.c.CVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtkiste.VagtKisteCommand;
import dev.crnyy.vagtsystem.plugins.vagtkiste.VagtKisteItem;
import dev.crnyy.vagtsystem.plugins.vagtkiste.VagtKisteTask;
import dev.crnyy.vagtsystem.plugins.vagtlevel.TestCommand;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevel;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelCommand;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelQuests;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenuListener;
import dev.crnyy.vagtsystem.plugins.vagtmine.ItemUtils;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMine;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMineCommand;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMineListener;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntime;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntimeCommand;
import dev.crnyy.vagtsystem.plugins.vagtshop.mainshop.VagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtshop.pvshop.listener.PvShopListener;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warplistener.AWarpShopListener;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warplistener.BWarpShopListener;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warplistener.CWarpShopListener;
import dev.crnyy.vagtsystem.plugins.vagtshop.warp.warplistener.MainWarpListener;
import dev.crnyy.vagtsystem.plugins.vagtwarps.SignManagerWarp;
import dev.crnyy.vagtsystem.plugins.vagtwarps.VagtWarpMenuListener;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Economy economy;
    private Config config;
    private Message message;


    @Override
    public void onEnable() {
        PlayerManager manager = new PlayerManager();
        if (!setupEconomy() ) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new PlaceholderAPI(this, manager).register();
        }
        Essentials essentials = (Essentials) getServer().getPluginManager().getPlugin("Essentials");


        this.config = new Config(this);
        this.message = new Message(this);

        listeners();
        commands();

        loadDataFile();
    }

    @Override
    public void onDisable() {

        saveDataFile();
        config.saveConfig();
    }

    private void listeners() {
        PlayerManager manager = new PlayerManager();
        Messages messages = new Messages(message);

        //Vagt
        this.getServer().getPluginManager().registerEvents(new SignManager(message, config), this);
        this.getServer().getPluginManager().registerEvents(new VagtMenuListener(config, messages, message), this);

        //VagtGearShop og EnchantShop
        this.getServer().getPluginManager().registerEvents(new CVagtShopListener(this, new Messages(message), config), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantItemsListener(new ArmorManager(), config, messages, new CVagtEnchantItems()), this);
        this.getServer().getPluginManager().registerEvents(new BVagtEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new BVagtEnchantItemsListener(new ArmorManager(), config, messages, new CVagtEnchantItems()), this);
        this.getServer().getPluginManager().registerEvents(new BVagtShopListener(this, new Messages(message), config), this);


        this.getServer().getPluginManager().registerEvents(new AVagtShopListener(this, new Messages(message), config), this);
        this.getServer().getPluginManager().registerEvents(new AVagtEnchantItemsListener(new ArmorManager(), config, messages, new CVagtEnchantItems()), this);
        this.getServer().getPluginManager().registerEvents(new AVagtEnchantListener(), this);
        //VagtChat
        this.getServer().getPluginManager().registerEvents(new VagtChat(messages), this);

        //VagtLevel
        this.getServer().getPluginManager().registerEvents(new VagtLevel(manager, new VagtLevelQuests()), this);

        //VagtOntime
        this.getServer().getPluginManager().registerEvents(new VagtOntime(this), this);

        //Repair
        this.getServer().getPluginManager().registerEvents(new Repair(config, message, messages), this);

        //VagtBuffs
        this.getServer().getPluginManager().registerEvents(new VagtBuffs(config, message), this);

        //Signs
        this.getServer().getPluginManager().registerEvents(new HealSign(config, message), this);

        this.getServer().getPluginManager().registerEvents(new VagtWarpMenuListener(this, config, messages),this);
        this.getServer().getPluginManager().registerEvents(new SignManagerWarp(message), this);

        //WarpShop
        this.getServer().getPluginManager().registerEvents(new VagtShopListener(config, message, messages, this), this);
        this.getServer().getPluginManager().registerEvents(new CWarpShopListener(config, message, messages), this);
        this.getServer().getPluginManager().registerEvents(new BWarpShopListener(config, message, messages), this);
        this.getServer().getPluginManager().registerEvents(new AWarpShopListener(config, message, messages), this);
        this.getServer().getPluginManager().registerEvents(new MainWarpListener(config, message, messages), this);

        //PvShop
        this.getServer().getPluginManager().registerEvents(new PvShopListener(config, message, messages, this), this);

        //Vagt Warps
        this.getServer().getPluginManager().registerEvents(new VagtWarpMenuListener(this, config, messages),this);
        this.getServer().getPluginManager().registerEvents(new SignManagerWarp(message), this);

        //vagtkiste
        this.getServer().getPluginManager().registerEvents(new VagtKisteTask(this), this);

        //Spassermine
        this.getServer().getPluginManager().registerEvents(new VagtMineListener(new VagtMine(), new ItemUtils()), this);
    }

    private void commands() {
        PlayerManager manager = new PlayerManager();
        Messages messages = new Messages(message);

        //Vagt
        this.getCommand("vagt").setExecutor(new VagtCommand(config, message));

        //VagtChat
        this.getCommand("vagtchat").setExecutor(new VagtChatCommand());

        //VagtLevel
        this.getCommand("vagtlevel").setExecutor(new VagtLevelCommand(manager));
        this.getCommand("irons").setExecutor(new TestCommand(new VagtLevelQuests()));

        //VagtMine
        this.getCommand("spassermine").setExecutor(new VagtMineCommand(new VagtMine(), config, this));

        //VagtCoins
        this.getCommand("vagtcoins").setExecutor(new VagtCoinsCommand(manager, new VagtCoinsMenu()));

        //VagtOntime
        VagtOntime ontime = new VagtOntime(this);
        this.getCommand("ontime").setExecutor(new VagtOntimeCommand(this, ontime));

        //Vagtkiste
        new VagtKisteCommand(new VagtKisteTask(this), new VagtKisteItem(), this);

    }

    private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    public static Economy getEconomy() {

        return economy;
    }


    public void loadDataFile() {
        Data.setup();
    }

    public void saveDataFile() {
        Data.save();
    }

}
