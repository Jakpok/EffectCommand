package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.AtomLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class AtomEffect extends EffectExecutor{

	public AtomEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    AtomLocationEffect effect = new AtomLocationEffect(this.plugin.getEffectManager(), player.getLocation());
		effect.particleNucleus = particle;
		effect.iterations = time * 20;
		effect.radius = size;
		effect.particlesNucleus = (int) (10 * (0.8 * size));
		effect.start();
		
	}

}
