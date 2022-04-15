package minigame.minigame;

import lombok.Getter;
import lombok.SneakyThrows;
import minigame.minigame.bukkit.commands.ForceStart;
import minigame.minigame.bukkit.position.PositionManager;
import minigame.minigame.common.players.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

public final class Minigame extends JavaPlugin {

    public static Minigame instance;
    public static Reflections r = new Reflections();

    @Getter
    private PlayerManager playerManager;
    public static World world = Bukkit.getWorld("World");

    @SneakyThrows
    @Override
    public void onEnable() {
        initManagers();
        register();
    }

    @Override
    public void onDisable() {
    }

    private void initManagers() throws InstantiationException, IllegalAccessException {
        PositionManager.init();
        playerManager = new PlayerManager();

    }

    @SneakyThrows
    @Override
    public void onLoad() {
        instance = this;
    }

    private void register() throws InstantiationException, IllegalAccessException {
        for(Class<?extends Listener> c : r.getSubTypesOf(Listener.class)) {
            Bukkit.getPluginManager().registerEvents(c.newInstance(), this);
        }

        for(Class<? extends CommandExecutor> c : new Reflections("minigame.minigame.bukkit.commands").getSubTypesOf(CommandExecutor.class)) {
            Bukkit.getPluginCommand(c.getSimpleName().toLowerCase()).setExecutor(c.newInstance());
        }

    }
}
