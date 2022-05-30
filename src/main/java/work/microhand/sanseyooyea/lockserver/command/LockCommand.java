package work.microhand.sanseyooyea.lockserver.command;

import org.bukkit.command.CommandSender;
import work.microhand.sanseyooyea.lockserver.LockServer;

/**
 * @author SanseYooyea
 */
public class LockCommand {
    public static void lock(CommandSender sender) {
        if (!sender.hasPermission("lockserver.lock")) {
            sender.sendMessage("§c| 权限不足！");
            return;
        }

        LockServer plugin = LockServer.getInstance();
        boolean lock = plugin.isLock();
        if (lock) {
            sender.sendMessage("§c| 服务器已锁定！");
            sender.sendMessage("§c| 锁定失败！");
            return;
        }

        plugin.setLock(true);
        plugin.getConfig().set("lock", true);
        plugin.saveConfig();
        sender.sendMessage("§a| 锁定成功！");
    }
}
