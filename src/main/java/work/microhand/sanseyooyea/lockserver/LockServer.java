package work.microhand.sanseyooyea.lockserver;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import work.microhand.sanseyooyea.lockserver.command.PluginCommand;
import work.microhand.sanseyooyea.lockserver.listener.PlayerJoinServerListener;
import work.microhand.sanseyooyea.lockserver.listener.PlayerLoginServerListener;

import java.util.Objects;

/**
 * @author SanseYooyea
 */
public final class LockServer extends JavaPlugin {

    private static LockServer instance;

    public LockServer() {
        instance = this;
    }

    public static LockServer getInstance() {
        return instance;
    }

    List<String> oldPlayers;

    public void loadOldPlayers() {
        reloadConfig();
        oldPlayers = getConfig().getStringList("players");
    }

    public List<String> getOldPlayers() {
        return oldPlayers;
    }

    private boolean lock;

    public void loadLock() {
        reloadConfig();
        lock = getConfig().getBoolean("lock");
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    public void onEnable() {
        getLogger().info("§a| §2Mount §a插件启动中...");
        getLogger().info("§a| 作者ID: §2SanseYooyea");
        getLogger().info("§a| 作者QQ：§21187586838");

        saveDefaultConfig();
        loadOldPlayers();
        loadLock();

        Objects.requireNonNull(getCommand("ls")).setExecutor(new PluginCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerLoginServerListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinServerListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("§a| §2Mount §a插件关闭中...");
        getLogger().info("§a| 作者ID: §2SanseYooyea");
        getLogger().info("§a| 作者QQ：§21187586838");
    }
}
