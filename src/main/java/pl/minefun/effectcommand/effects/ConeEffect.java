package pl.minefun.effectcommand.effects;

import org.bukkit.entity.Player;

import pl.minefun.effectcommand.EffectCommand;
import pl.minefun.effectcommand.EffectExecutor;
import de.slikey.effectlib.effect.ConeLocationEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class ConeEffect extends EffectExecutor{

	public ConeEffect(EffectCommand plugin) {
		super(plugin);
	}

	@Override
	protected void effect(Player player, ParticleEffect particle, int time, int size) {
	    ConeLocationEffect effect = new ConeLocationEffect(this.plugin.getEffectManager(), player.getLocation().add(0,2,0));
		effect.particle = particle;
		effect.iterations = time * 20;
		effect.particles = size *2;
		effect.start();
		
	}

}
