package pl.pijok.playerzombies.zombie;

public class ZombieStats {

    private double speed;
    private double health;
    private double damage;

    public ZombieStats(double speed, double health, double damage) {
        this.speed = speed;
        this.health = health;
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
