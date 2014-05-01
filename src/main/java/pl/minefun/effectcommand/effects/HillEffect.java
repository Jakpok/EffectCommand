package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.HillLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class HillEffect extends EffectExecutor{

	public HillEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    HillLocationEffect effect = new HillLocationEffect(this.plugin.getEffectManager(), player.getLocation().add(0,3,0));
	    effect.particle = particle;
	    effect.iterations = time * 2;
	    effect.edgeLenght = size * 2;
	    effect.height = size;
	    effect.particles = size * 6;
	    effect.start();
		
	}

}