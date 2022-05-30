package work.microhand.sanseyooyea.lockserver.command;

import org.bukkit.command.CommandSender;
import work.microhand.sanseyooyea.lockserver.LockServer;

/**
 * @author SanseYooyea
 */
public class ReloadCommand {
    public static void reload(CommandSender sender) {

        if (!sender.hasPermission("lockserver.reload")) {
            sender.sendMessage("§c| 权限不足！");
        }

        LockServer.getInstance().loadOldPlayers();
        LockServer.getInstance().loadLock();
        sender.sendMessage("§a| 重载成功！");
    }
}
