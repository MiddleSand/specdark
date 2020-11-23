package specdark;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class CustomChunkGenerator extends ChunkGenerator {
    int currentHeight = 50;
    public static int ceilingHeight; //default 86
    public static double floorOffset; //default 50, sets the "ground level" that the generator augments from.
    public static int diamondRarity; //default 4

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
    	SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 4);
  
        ChunkData chunk = createChunkData(world);
        generator.setScale(0.005D);
        int det = random.nextInt(10000);
		if(det<=500) {
			for (int X = 0; X < 16; X++)
	            for (int Z = 0; Z < 16; Z++)	{
		            for (int Y = 0; Y < 100; Y++)	{
		            	chunk.setBlock(X, Y, Z, Material.BEDROCK);
		            }
	            }
		}else {
        for (int X = 0; X < 16; X++)
            for (int Z = 0; Z < 16; Z++) {
                currentHeight = (int) (generator.noise(chunkX*16+X, chunkZ*16+Z, 0.05D, 0.05D)*15D+floorOffset);
                if(random.nextInt(1000) <= 333) {
                	chunk.setBlock(X, currentHeight, Z, Material.GRASS_PATH);
                }else if(random.nextInt(1000) <= 667) {
                	chunk.setBlock(X, currentHeight, Z, Material.PODZOL);
                }else {
                	chunk.setBlock(X, currentHeight, Z, Material.COARSE_DIRT);
                }
                chunk.setBlock(X, currentHeight-1, Z, Material.DIRT);               
        		chunk.setBlock(X, ceilingHeight, Z, Material.BEDROCK); //default 86 & 87
        		chunk.setBlock(X, ceilingHeight + 1, Z, Material.BEDROCK);
        		if(random.nextInt(1000) <= 100) {
            		if(random.nextInt(1000) <= 100) {
            			chunk.setBlock(X, currentHeight+1, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+2, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+3, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+4, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+5, Z, Material.SPRUCE_LOG);	
            			chunk.setBlock(X, currentHeight+6, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+7, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+8, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+9, Z, Material.SPRUCE_LOG);
            		}
            		if(random.nextInt(1000) <= 50) {
            			chunk.setBlock(X, currentHeight+1, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+2, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+3, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+4, Z, Material.DARK_OAK_LOG);
            		}
            		if(random.nextInt(1000) <= 10) {
            			chunk.setBlock(X, currentHeight+1, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+2, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+3, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+4, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+5, Z, Material.SPRUCE_LOG);	

            		}
        		}else{
            		if(random.nextInt(1000) <= 100) {
            			chunk.setBlock(X, currentHeight+1, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+2, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+3, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+4, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+5, Z, Material.SPRUCE_LOG);	
            			chunk.setBlock(X, currentHeight+6, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+7, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+8, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+9, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+10, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+11, Z, Material.SPRUCE_LOG);
            			chunk.setBlock(X, currentHeight+12, Z, Material.SPRUCE_LOG);
            			
            		}
            		if(random.nextInt(1000) <= 50) {
            			chunk.setBlock(X, currentHeight+1, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+2, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+3, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+4, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+5, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+6, Z, Material.DARK_OAK_LOG);
            			chunk.setBlock(X, currentHeight+7, Z, Material.DARK_OAK_LOG);
            		}
            		if(random.nextInt(1000) <= 10) {
            			chunk.setBlock(X, currentHeight+1, Z, Material.PUMPKIN);
            		}
        		}

        		
        		int determiner = random.nextInt(10000);
        		if(determiner<=5000)
        		{
        			chunk.setBlock(X, 85, Z, Material.BLACKSTONE);
        		}
        		if(determiner<=50)
        		{
        			chunk.setBlock(X, 85, Z, Material.MAGMA_BLOCK);
        		}
        		if(determiner<=10)
        		{
        			chunk.setBlock(X, 85, Z, Material.SEA_LANTERN);
        		}
        		if(determiner<=diamondRarity)
        		{
        			chunk.setBlock(X, 85, Z, Material.DIAMOND_BLOCK);
        		}
                for (int i = currentHeight-2; i > 0; i--)
                	{
                	chunk.setBlock(X, i, Z, Material.STONE);
                	}
                chunk.setBlock(X, 0, Z, Material.BEDROCK);
            }}
        
        return chunk;
    }
    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList((BlockPopulator)new OrePopulator());
    }

}