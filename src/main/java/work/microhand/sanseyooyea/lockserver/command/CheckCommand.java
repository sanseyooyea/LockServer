package work.microhand.sanseyooyea.lockserver.command;

import org.bukkit.command.CommandSender;
import work.microhand.sanseyooyea.lockserver.LockServer;

/**
 * @author SanseYooyea
 */
public class CheckCommand {

    public static void check(CommandSender sender) {
        if (!sender.hasPermission("lockserver.check")) {
            sender.sendMessage("§c| 权限不足！");
            return;
        }

        sender.sendMessage("§a| 锁定状态：§e" + LockServer.getInstance().isLock());
    }
}
