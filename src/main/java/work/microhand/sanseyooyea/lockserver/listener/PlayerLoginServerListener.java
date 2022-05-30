package work.microhand.sanseyooyea.lockserver.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import work.microhand.sanseyooyea.lockserver.LockServer;

import java.util.List;

/**
 * @author SanseYooyea
 */
public class PlayerLoginServerListener implements Listener {

    @EventHandler
    public void onPlayerLoginServer(PlayerLoginEvent event) {
        boolean lock = LockServer.getInstance().isLock();

        if (!lock) {
            return;
        }

        List<String> oldPlayers = LockServer.getInstance().getOldPlayers();
        if (oldPlayers.contains(event.getPlayer().getName())) {
            return;
        }

        event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§e[LockServer] §c服务器已经被锁定，请稍后再试！");
    }
}
