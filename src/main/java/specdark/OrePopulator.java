package specdark;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class OrePopulator extends BlockPopulator{
	public static int tries; //default 18
	public static int chance; //default 80
	public static int maxHeight; //default 40
	public static int heightOffset; //default 20
	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int X, Y, Z;
		boolean isStone;
		for (int i = 1; i < tries; i++) {  // Number of tries
		    if (random.nextInt(100) < chance) {  // The chance of spawning
			X = random.nextInt(15);
			Z = random.nextInt(15);
			Y = random.nextInt(maxHeight)+heightOffset;  // Get randomized coordinates
			if (chunk.getBlock(X, Y, Z).getType() == Material.STONE) {
			    chunk.getBlock(X, Y, Z).setType(Material.GOLD_ORE);
			    chunk.getBlock(X, Y+1, Z).setType(Material.GOLD_ORE);
			    chunk.getBlock(X, Y-1, Z).setType(Material.GOLD_ORE);
			}
		    }
		}
	}
}
