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
        if (args.length == 0) {
            HelpCommand.sendHelpMessage(sender);
            return true;
        }

        if (args.length == 1) {
            if ("help".equalsIgnoreCase(args[0])) {
                HelpCommand.sendHelpMessage(sender);
                return true;
            }

            if ("lock".equalsIgnoreCase(args[0])) {
                LockCommand.lock(sender);
                return true;
            }

            if ("unlock".equalsIgnoreCase(args[0])) {
                UnlockCommand.unlock(sender);
                return true;
            }

            if ("check".equalsIgnoreCase(args[0])) {
                CheckCommand.check(sender);
                return true;
            }

            if ("reload".equalsIgnoreCase(args[0])) {
                ReloadCommand.reload(sender);
                return true;
            }
        }

        sender.sendMessage("§c| 未知指令！");
        HelpCommand.sendHelpMessage(sender);

        return true;
    }
}
