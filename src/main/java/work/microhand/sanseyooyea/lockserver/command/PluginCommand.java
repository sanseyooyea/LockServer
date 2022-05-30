package work.microhand.sanseyooyea.lockserver.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * @author SanseYooyea
 */
public class PluginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String flag = args[0].toLowerCase();

        switch (flag) {
            case "help":
                HelpCommand.sendHelpMessage(sender);
                break;
            case "lock":
                LockCommand.lock(sender);
                break;
            case "unlock":
                UnlockCommand.unlock(sender);
                break;
            case "check":
                CheckCommand.check(sender);
                break;
            case "reload":
                ReloadCommand.reload(sender);
                break;
            default:
                sender.sendMessage("§c| 无效的指令！");
                HelpCommand.sendHelpMessage(sender);
                break;
        }

        return true;
    }
}
