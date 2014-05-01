package pl.minefun.effectcommand;

import lombok.RequiredArgsConstructor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.slikey.effectlib.util.ParticleEffect;


@RequiredArgsConstructor
public class CommandBase implements CommandExecutor {
	
	private final EffectCommand plugin;
	
	  public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    if (sender instanceof Player) {
	    	Player player = (Player) sender;
	    	if(args.length == 0){
	    		String effectList = "";
	    		player.sendMessage("§aList of available effects:");
	    		for(String name : plugin.effectMap.keySet()){
	    			effectList += "§6" + name + "§a, ";
	    		}
	    		player.sendMessage(effectList);
	    	}
	    	else if(args.length > 0){
	    		String name = args[0];
	    		if(name.equalsIgnoreCase("p")){
		    		String effectList = "";
		    		for(ParticleEffect effect : ParticleEffect.values()){
		    			effectList += "§3" + effect.getName() + "§a, ";
		    		}
					player.sendMessage("§6Available particle names: §6" + effectList);
	    			return true;
	    		}
	    		else if(player.hasPermission("effect." + name)){
		    		if(plugin.effectMap.containsKey(name)){
		    			plugin.effectMap.get(name).prepareEffect(player, args);
		    		}
		    		else{
		    			player.sendMessage("§4That effect doesn't exists!");
		    		}
		    	}
		    	else{
		    		player.sendMessage("§4You don't have enough permissions!");
		    	}
	    	}
	    }
	    else{
	    	sender.sendMessage("You can't execute this command because you are not a player!");
	    }
	    return true;
	  }

}
