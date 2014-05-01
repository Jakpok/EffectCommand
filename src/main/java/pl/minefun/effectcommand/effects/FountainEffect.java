package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.FountainLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class FountainEffect extends EffectExecutor{

	public FountainEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
		FountainLocationEffect effect = new FountainLocationEffect(this.plugin.getEffectManager(), player.getLocation());
		effect.particle = particle;
		effect.iterations = time * 5;
		effect.radius = size;
		effect.height = size;
		effect.heightSpout = size + 2;
		effect.start();
		
	}

}
