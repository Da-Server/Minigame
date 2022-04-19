package minigame.minigame.bukkit.commands;
import minigame.minigame.bukkit.configs.impl.chat.placeholders.ChatPlaceHoldersConfig;
import minigame.minigame.bukkit.configs.impl.sound.SoundConfig;
import minigame.minigame.bukkit.game.Game;
import minigame.minigame.bukkit.game.custom.core.GameStartEvent;
import minigame.minigame.common.commands.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceStart implements CommandExecutor {

    private final ChatPlaceHoldersConfig placeHoldersConfig = ChatPlaceHoldersConfig.get();
    private final SoundConfig soundConfig = SoundConfig.get();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player)commandSender;
            if(p.isOp() || p.hasPermission(PermissionManager.FORCE_START)) {
                if(!Game.isRunning()) {
                    Bukkit.getPluginManager().callEvent(new GameStartEvent(true));
                    Bukkit.broadcastMessage(placeHoldersConfig.getData().getForceStartMessage());
                } else {
                    p.sendMessage(placeHoldersConfig.getData().getRunningMessage());
                    p.playSound(p.getLocation(), soundConfig.getData().getErrorSound(), 2, 0.1f);
                }
            }
        }
        return false;
    }
}
