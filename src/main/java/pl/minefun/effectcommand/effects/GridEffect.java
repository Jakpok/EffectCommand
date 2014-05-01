package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.GridLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class GridEffect extends EffectExecutor{

	public GridEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    GridLocationEffect effect = new GridLocationEffect(this.plugin.getEffectManager(), player.getLocation());
	    effect.particle = particle;
	    effect.iterations = time * 4;
	    effect.rows = size;
	    effect.columns = size;
	    effect.start();
		
	}

}