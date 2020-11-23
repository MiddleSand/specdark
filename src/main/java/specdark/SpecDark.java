package specdark;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
public class SpecDark extends JavaPlugin {
	public static SpecDark self;
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		CustomChunkGenerator.ceilingHeight = this.getConfig().getInt("ceiling-height");
		CustomChunkGenerator.floorOffset = this.getConfig().getInt("floor-offset");
		CustomChunkGenerator.diamondRarity = this.getConfig().getInt("diamondRarity");
		OrePopulator.tries = this.getConfig().getInt("ore-tries");
		OrePopulator.heightOffset = this.getConfig().getInt("ore-height-offset");
		OrePopulator.maxHeight = this.getConfig().getInt("ore-max-height");
		OrePopulator.chance = this.getConfig().getInt("ore-chance");
		DarkListener.blindnessChanceOne = this.getConfig().getInt("blindness-one");
		DarkListener.blindnessChanceTwo = this.getConfig().getInt("blindness-two");
		DarkListener.blindnessChanceThree = this.getConfig().getInt("blindness-three");
		DarkListener.noiseChance = this.getConfig().getInt("noise-chance");
		getLogger().info("Spec-Dark v.1.1.7: Spoooooky!");
		getLogger().info("Spec-Dark 1.1.7 Enabled");
		getServer().getPluginManager().registerEvents(new DarkListener(), this);
		self=this;
	}

	@Override
	public void onDisable() {
		getLogger().info("Spec-Dark 1.1.7 Disabled");
	}
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
	    return new CustomChunkGenerator();
	}
	
	
}
