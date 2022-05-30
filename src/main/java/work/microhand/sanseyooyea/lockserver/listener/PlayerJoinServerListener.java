package work.microhand.sanseyooyea.lockserver.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import work.microhand.sanseyooyea.lockserver.LockServer;

import java.util.List;

/**
 * @author SanseYooyea
 */
public class PlayerJoinServerListener implements Listener {
    @EventHandler
    public void onPlayerJoinServer(PlayerJoinEvent event) {
        List<String> oldPlayers = LockServer.getInstance().getOldPlayers();

        Player player = event.getPlayer();
        if (oldPlayers.contains(player.getName())) {
            return;
        }

        oldPlayers.add(player.getName());
        LockServer.getInstance().getConfig().set("players", oldPlayers);
        LockServer.getInstance().saveConfig();
    }
}
