package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.HelixLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class HelixEffect extends EffectExecutor{

	public HelixEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    HelixLocationEffect effect = new HelixLocationEffect(this.plugin.getEffectManager(), player.getLocation().add(0,3,0));
	    effect.particle = particle;
	    effect.iterations = time * 2;
	    effect.particles = size * 4;
	    effect.radius = size;
	    effect.start();
		
	}

}