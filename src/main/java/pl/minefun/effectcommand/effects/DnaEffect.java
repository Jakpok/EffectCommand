package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.DnaLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class DnaEffect extends EffectExecutor{

	public DnaEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
		DnaLocationEffect effect = new DnaLocationEffect(this.plugin.getEffectManager(), player.getLocation());
	    effect.particleHelix = particle;
	    effect.iterations = time * 20;
	    effect.lenght = size;
	    effect.start();
		
	}

}