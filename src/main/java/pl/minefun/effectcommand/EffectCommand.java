package pl.minefun.effectcommand;


import java.util.HashMap;
import java.util.logging.Logger;

import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import pl.minefun.effectcommand.effects.ArcEffect;
import pl.minefun.effectcommand.effects.AtomEffect;
import pl.minefun.effectcommand.effects.ConeEffect;
import pl.minefun.effectcommand.effects.CubeEffect;
import pl.minefun.effectcommand.effects.DnaEffect;
import pl.minefun.effectcommand.effects.DonutEffect;
import pl.minefun.effectcommand.effects.FountainEffect;
import pl.minefun.effectcommand.effects.GridEffect;
import pl.minefun.effectcommand.effects.HelixEffect;
import pl.minefun.effectcommand.effects.HillEffect;
import pl.minefun.effectcommand.effects.LineEffect;
import pl.minefun.effectcommand.effects.ShieldEffect;
import pl.minefun.effectcommand.effects.StarEffect;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;

public class EffectCommand extends JavaPlugin {
	
	@Getter
	private EffectManager effectManager;
	@Getter
	private ConfigManager configManager;
	//
	public HashMap<String, EffectExecutor> effectMap = new HashMap<String, EffectExecutor>();
	//
	public static Logger logger;
	
	public void onEnable(){
		EffectCommand.logger = getLogger();
		try {
		    checkEffectLib();
		} catch (Exception e) {
		    e.printStackTrace();
		    logger.warning("Error: EffectLib not found!");
		    setEnabled(false);
		    return;
		}
		this.configManager = new ConfigManager(this);
		configManager.init();
		prepareEffectMap();
		getCommand("eff").setExecutor(new CommandBase(this));
		logger.info("EffectCommand enabled!");     
	}
	
	public void onDisable(){
		logger.info("EffectCommand disabled!");
		effectManager.dispose();
	}
	
    private void checkEffectLib() throws Exception{
        if(!Bukkit.getPluginManager().isPluginEnabled("EffectLib")){
             throw new Exception("Plugin EffectLib not found. Disabling EffectCommand. You can download required plugin here: http://dev.bukkit.org/bukkit-plugins/effectlib/");
         }
         EffectLib lib = EffectLib.instance();
         effectManager = new EffectManager(lib);
         logger.info("EffectLib hooked!");
     }
    
    private void prepareEffectMap(){
    	effectMap.put("arc", new ArcEffect(this));
    	effectMap.put("atom", new AtomEffect(this));
    	effectMap.put("cone", new ConeEffect(this));
    	effectMap.put("cube", new CubeEffect(this));
    	effectMap.put("dna", new DnaEffect(this));
    	effectMap.put("donut", new DonutEffect(this));
    	effectMap.put("fountain", new FountainEffect(this));
    	effectMap.put("helix", new HelixEffect(this));
    	effectMap.put("hill", new HillEffect(this));
    	effectMap.put("grid", new GridEffect(this));
    	effectMap.put("line", new LineEffect(this));
    	effectMap.put("shield", new ShieldEffect(this));
    	effectMap.put("star", new StarEffect(this));
    }

}
