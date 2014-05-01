package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.ShieldEntityEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class ShieldEffect extends EffectExecutor{

	public ShieldEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
		ShieldEntityEffect effect = new ShieldEntityEffect(this.plugin.getEffectManager(), player);
		effect.particle = particle;
		effect.iterations = time * 20;
		effect.radius = size;
		effect.start();		
	}

}
