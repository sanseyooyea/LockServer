package work.microhand.sanseyooyea.lockserver.command;

import org.bukkit.command.CommandSender;
import work.microhand.sanseyooyea.lockserver.LockServer;

/**
 * @author SanseYooyea
 */
public class UnlockCommand {
    public static void unlock(CommandSender sender) {
        if (!sender.hasPermission("lockserver.unlock")) {
            sender.sendMessage("§c| 权限不足！");
            return;
        }

        LockServer plugin = LockServer.getInstance();

        boolean lock = plugin.isLock();
        if (!lock) {
            sender.sendMessage("§c| 服务器未被锁定！");
            sender.sendMessage("§c| 解锁失败！");
            return;
        }

        plugin.setLock(false);
        plugin.getConfig().set("lock", false);
        plugin.saveConfig();
        sender.sendMessage("§a| 解锁成功！");
    }
}
