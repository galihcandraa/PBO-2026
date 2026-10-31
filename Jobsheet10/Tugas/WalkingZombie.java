package Jobsheet10.Tugas;

public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    @Override
    public void heal() {
        switch (level) {
            case 1:
                health += health * 10 / 100;
                break;
            case 2:
                health += health * 30 / 100;
                break;
            case 3:
                health += health * 40 / 100;
                break;
        }
    }

    @Override
    public void destroyed() {
        health -= health * 20 / 100;
    }

    @Override
    public String getZombieInfo() {
        String msg = "Walking Zombie Data = \n";
        msg += super.getZombieInfo() + "\n";
        return msg;
    }
}
