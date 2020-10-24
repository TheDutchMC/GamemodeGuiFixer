package nl.thedutchmc.GamemodeGuiFixer.eventListeners;

import nl.thedutchmc.GamemodeGuiFixer.GamemodeGuiFixer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerWorldChangedEventListener implements Listener {
    @EventHandler
    public void onPlayerWorldChangedEvent(PlayerChangedWorldEvent event) {
        GamemodeGuiFixer.INSTANCE.permissionUpdate(event.getPlayer());
    }
}