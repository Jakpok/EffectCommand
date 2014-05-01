package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.StarLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class StarEffect extends EffectExecutor{

	public StarEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    StarLocationEffect effect = new StarLocationEffect(this.plugin.getEffectManager(), player.getLocation().add(0,2,0));
		effect.particle = particle;
		effect.iterations = time * 5;
		effect.spikeHeight = size;
		effect.start();
		
	}

}
