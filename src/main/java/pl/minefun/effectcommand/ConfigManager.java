package pl.minefun.effectcommand;

import org.bukkit.configuration.file.FileConfiguration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfigManager {

	private final EffectCommand plugin;
	
	private FileConfiguration config;
	
	public int maxRadius = 10;
	public int maxTime = 10;
	
	public void init(){
		try {
		    config = plugin.getConfig();
		    config.options().copyDefaults(true);
		    //config.options().header("EffectCommand Config");
		    //config.options().copyHeader(true);
		    plugin.saveConfig();
		    plugin.reloadConfig();
		}
		catch (Throwable e) {
		    e.printStackTrace();
		}
		this.maxRadius = plugin.getConfig().getInt("maxRadius", 50);
		this.maxTime = plugin.getConfig().getInt("maxTime", 120);
	}

}
