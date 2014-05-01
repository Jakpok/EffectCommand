package pl.minefun.effectcommand;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.entity.Player;

import de.slikey.effectlib.util.ParticleEffect;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class EffectExecutor {
	
	protected final EffectCommand plugin;
	
	public final void prepareEffect(Player player, String[] args){
		//
		ParticleEffect particleEffect = ParticleEffect.FLAME;
		int effectTime = 10;
		int effectSize = 10;
		//
		//remove first argument - effect name
		args = (String[]) ArrayUtils.removeElement(args, args[0]);
		//
		if(args != null && args.length>0){
			for(String arg : args){
				if(arg.startsWith("t:")){
					String timeString = arg.replace("t:", "");
					if(MathUtil.isInt(timeString)){
						int time = MathUtil.toInt(timeString);
						if(time < plugin.getConfigManager().maxTime){
							effectTime = time;
						}
						else{
							player.sendMessage("§cGiven time argument is too long!");
							return;
						}
					}
					else{
						player.sendMessage("§cGiven time argument is not a number!");
						return;
					}
				}
				else if(arg.startsWith("p:")){
					String particleName = arg.replace("p:", "");
					ParticleEffect particle = ParticleEffect.fromName(particleName);
					if(particle != null){
						particleEffect = particle;
					}
					else{
			    		String effectList = "";
			    		for(ParticleEffect effect : ParticleEffect.values()){
			    			effectList += "§6" + effect.getName() + "§a, ";
			    		}
						player.sendMessage("§cParticle not found! Available particle names: §6" + effectList);
						return;
					}	
				}
				else if(arg.startsWith("s:")){
					String sizeString = arg.replace("s:", "");
					if(MathUtil.isInt(sizeString)){
						int size = MathUtil.toInt(sizeString);
						if(size < plugin.getConfigManager().maxRadius){
							effectSize = size;
						}
						else{
							player.sendMessage("§cGiven size argument is too big!");
							return;
						}
					}
					else{
						player.sendMessage("§cGiven size argument is not a number!");
						return;
					}	 
				}
				else{
					player.sendMessage("§cArgument §e" + arg + " §ccan't be applied to effect!");
					return;
				}
			}
		}
		player.sendMessage("§2§oLet the show begin!");
		effect(player, particleEffect, effectTime, effectSize);
	}
	
	protected abstract void effect(Player player, ParticleEffect effect, int time, int size);

}
