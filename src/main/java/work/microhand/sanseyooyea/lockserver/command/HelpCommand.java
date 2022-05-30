package work.microhand.sanseyooyea.lockserver.command;

import org.bukkit.command.CommandSender;

/**
 * @author SanseYooyea
 */
public class HelpCommand {

    public static void sendHelpMessage(CommandSender sender) {
        sender.sendMessage("§a| §2LockServer §a插件帮助系统");
        sender.sendMessage("§a| §2/ls help §a- §2显示帮助信息");
        if (sender.hasPermission("lockserver.admin")) {
            sender.sendMessage("§a| §2/ls lock §a- §2锁定服务器");
            sender.sendMessage("§a| §2/ls unlock §a- §2解锁服务器");
            sender.sendMessage("§a| §2/ls check §a- §2查看服务器锁定状态");
            sender.sendMessage("§a| §2/ls reload §a- §2重载配置文件");
        }

    }
}
