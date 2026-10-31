package Jobsheet10.Tugas;

public abstract class Zombie implements Destroyable {
    protected int health, level;

    public abstract void heal();

    public abstract void destroyed();

    public String getZombieInfo() {
        String msg = "Health = " + health;
        msg += "\nlevel = " + level;
        return msg;
    }
}
