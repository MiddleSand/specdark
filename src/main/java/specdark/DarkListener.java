package specdark;
import java.util.Random;
import java.util.logging.Level;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DarkListener implements Listener
{
	public static int blindnessChanceOne; //default 201
	public static int blindnessChanceTwo; //default 50
	public static int blindnessChanceThree; //default 17
	public static int noiseChance; //default 50
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event)
    {
    	if (event.getEntityType() == EntityType.PLAYER)
    	{
    		Player player = (Player) event.getEntity();
    		try{
    			if(player.getWorld().getGenerator().getClass() == CustomChunkGenerator.class) {
    				Random randy = new Random();
    				if(randy.nextInt(1000)<=201) {
    					if(randy.nextInt(1000)<=50) {
    						player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2400, 1, true));
    					}else {
    						player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 1, true));
    					}
    				}else if(randy.nextInt(1000)<=17) {
    					player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 1, true));
    					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 2, true));
    				}

    			}
    		}catch(NullPointerException e) {
    			
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event)
    {
    		Entity player = (Entity) event.getEntity();
    		try{
    			if(player.getWorld().getGenerator().getClass() == CustomChunkGenerator.class) {
    				Random randy = new Random();
    				if(randy.nextInt(100)<=50) {
    					player.getWorld().playSound(player.getLocation(), Sound.AMBIENT_CAVE, SoundCategory.AMBIENT, 5f, 0.01f);
    				}

    			}
    		}catch(NullPointerException e) {
    			
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    }
}