package pl.pijok.playerzombies.zombie;

import de.tr7zw.changeme.nbtapi.NBTEntity;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.pijok.playerzombies.API;

import java.util.Random;

public class ZombieController {

    private final Random random;

    private boolean enabled;
    private boolean poisonOnHit;
    private int poisonLevel;
    private int poisonDuration;
    private String zombieName;
    private boolean transferInventory;
    private boolean spawnCustomZombie;
    private ZombieStats zombieStats;
    private double babyZombieChance;

    public ZombieController(){
        random = new Random();
    }

    public void loadSettings(){
        YamlConfiguration configuration = API.getConfigProvider().load("config.yml");

        enabled = configuration.getBoolean("enabled");
        poisonOnHit = configuration.getBoolean("poisonOnHit");
        poisonLevel = configuration.getInt("poison.level");
        poisonDuration = configuration.getInt("poison.duration");
        zombieName = configuration.getString("zombieName");
        spawnCustomZombie = configuration.getBoolean("spawnCustomZombie");
        zombieStats = new ZombieStats(
                configuration.getDouble("customZombieStats.speed"),
                configuration.getDouble("customZombieStats.health"),
                configuration.getDouble("customZombieStats.damage")
        );

        babyZombieChance = configuration.getDouble("babyZombieChance");
    }

    public void spawnZombie(Player player, Location location){
        if(!enabled){
            return;
        }

        boolean baby = babyZombieChance < (random.nextDouble() * 100);

        Zombie zombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        if(baby){
            zombie.setBaby();
        }

        String name = zombieName;
        name = name.replace("{NICKNAME}", player.getName());
        name = API.getChatManager().fixColor(name);

        zombie.setCustomName(name);
        zombie.setCustomNameVisible(true);

        if(spawnCustomZombie){
            NBTEntity nbtEntity = new NBTEntity(zombie);
            nbtEntity.setDouble("GENERIC_ATTACK_DAMAGE", getZombieStats().getDamage());
            nbtEntity.setDouble("GENERIC_MOVEMENT_SPEED", getZombieStats().getSpeed());
            nbtEntity.setDouble("GENERIC_MAX_HEALTH", getZombieStats().getHealth());
        }

        if(transferInventory){
            zombie.getEquipment().setItemInMainHand(player.getInventory().getItemInMainHand());
            zombie.getEquipment().setArmorContents(player.getInventory().getArmorContents());
        }

    }

    public void handleZombieHit(Player player){
        if(poisonOnHit){
            if(!player.hasPotionEffect(PotionEffectType.POISON)){
                player.addPotionEffect(new PotionEffect(
                        PotionEffectType.POISON,
                        poisonDuration,
                        poisonLevel
                ));
            }
        }
    }

    public Random getRandom() {
        return random;
    }

    public int getPoisonLevel() {
        return poisonLevel;
    }

    public void setPoisonLevel(int poisonLevel) {
        this.poisonLevel = poisonLevel;
    }

    public int getPoisonDuration() {
        return poisonDuration;
    }

    public void setPoisonDuration(int poisonDuration) {
        this.poisonDuration = poisonDuration;
    }

    public String getZombieName() {
        return zombieName;
    }

    public void setZombieName(String zombieName) {
        this.zombieName = zombieName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isPoisonOnHit() {
        return poisonOnHit;
    }

    public void setPoisonOnHit(boolean poisonOnHit) {
        this.poisonOnHit = poisonOnHit;
    }

    public boolean isSpawnCustomZombie() {
        return spawnCustomZombie;
    }

    public void setSpawnCustomZombie(boolean spawnCustomZombie) {
        this.spawnCustomZombie = spawnCustomZombie;
    }

    public ZombieStats getZombieStats() {
        return zombieStats;
    }

    public void setZombieStats(ZombieStats zombieStats) {
        this.zombieStats = zombieStats;
    }

    public double getBabyZombieChance() {
        return babyZombieChance;
    }

    public void setBabyZombieChance(double babyZombieChance) {
        this.babyZombieChance = babyZombieChance;
    }

    public boolean isTransferInventory() {
        return transferInventory;
    }

    public void setTransferInventory(boolean transferInventory) {
        this.transferInventory = transferInventory;
    }
}
