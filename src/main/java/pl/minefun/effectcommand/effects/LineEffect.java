package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.LineLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class LineEffect extends EffectExecutor{

	public LineEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    LineLocationEffect effect = new LineLocationEffect(this.plugin.getEffectManager(), player.getEyeLocation(), player.getTargetBlock(null, 50).getLocation());
		effect.particle = particle;
		effect.iterations = time * 20;
		effect.start();		
	}

}