package nl.thedutchmc.GamemodeGuiFixer;

import nl.thedutchmc.GamemodeGuiFixer.eventListeners.PlayerJoinEventListener;
import nl.thedutchmc.GamemodeGuiFixer.eventListeners.PlayerWorldChangedEventListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class GamemodeGuiFixer extends JavaPlugin {
    public static GamemodeGuiFixer INSTANCE;
    public static String NMS_VERSION = Bukkit.getServer().getClass().getPackage().getName().substring(23);

    public void onEnable() {
        INSTANCE = this;

        Bukkit.getPluginManager().registerEvents((Listener)new PlayerJoinEventListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerWorldChangedEventListener(), (Plugin)this);
    }

    public void permissionUpdate(final Player p) {
        if (!p.hasPermission("ggf.use")) return;  
        
        new BukkitRunnable({
                public void run() {
                    GamemodeGuiFixer.this.sendEntityStatus(p);
                    GamemodeGuiFixer.logInfo("Patching player " + p.getName());
            }
            }).runTaskLater((Plugin)INSTANCE, 10L);
        }

        private void sendEntityStatus(Player p) {
        PermissionFixer fixer = null;

        switch (NMS_VERSION) { 
            case "v1_16_R1": fixer = new PermissionFixer_1_16_R1(); break;
            case "v1_16_R2": fixer = new PermissionFixer_1_16_R2(); break;
            default:
                logInfo("This plugin does not support " + NMS_VERSION + "!");
                return; 
        }

        fixer.patch(p);
    }

    public static void logInfo(String log) {
        INSTANCE.getLogger().info(log);
    }

    public static void logWarn(String log) {
        INSTANCE.getLogger().warning(log);
    }
}
