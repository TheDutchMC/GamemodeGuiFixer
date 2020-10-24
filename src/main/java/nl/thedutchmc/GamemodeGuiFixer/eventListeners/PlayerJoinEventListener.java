package nl.thedutchmc.GamemodeGuiFixer.eventListeners;

import nl.thedutchmc.GamemodeGuiFixer.GamemodeGuiFixer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoinEventListener implements Listener {
  
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        GamemodeGuiFixer.INSTANCE.permissionUpdate(event.getPlayer());
    }
}