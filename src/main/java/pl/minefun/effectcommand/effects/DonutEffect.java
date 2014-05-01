package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.DonutLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class DonutEffect extends EffectExecutor{

	public DonutEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
		DonutLocationEffect effect = new DonutLocationEffect(this.plugin.getEffectManager(), player.getLocation());
		effect.particle = particle;
		effect.iterations = time * 2;
		effect.radiusDonut = size;
		effect.particlesCircle = effect.particlesCircle * (size/2);
		effect.radiusTube = size/4;
		effect.start();
		
	}

}