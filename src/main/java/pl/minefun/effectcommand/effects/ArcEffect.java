package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import de.slikey.effectlib.effect.ArcLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;

public class ArcEffect extends EffectExecutor{

	public ArcEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    ArcLocationEffect effect = new ArcLocationEffect(this.plugin.getEffectManager(), player.getLocation(), player.getTargetBlock(null, 50).getLocation());
		effect.particle = particle;
		effect.iterations = time * 20;
		effect.height = size;
		effect.particles = (int) (10 * (0.8 * size));
		effect.start();
		
	}

}
