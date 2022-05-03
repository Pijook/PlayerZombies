package pl.pijok.playerzombies;

import pl.pijok.playerzombies.zombie.ZombieController;

public class Controllers {

    private static ZombieController zombieController;

    public static void create(){
        zombieController = new ZombieController();
    }

    public static ZombieController getZombieController() {
        return zombieController;
    }
}
