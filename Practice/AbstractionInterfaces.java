public class AbstractionInterfaces {
    public static void main(String[] args) {
        Tribrid t = new Tribrid();
        System.out.println(t.name);
        t.bite();
        t.enchant();
    }
}

interface Specie {
    boolean isLiving = true;
}

interface Wolf extends Specie {
    boolean canDie = true;
    boolean isStrong = true;

    void bite();
}

interface Vampire extends Specie {
    boolean canDie = true;
    boolean isStrong = true;

    void bite();
}

interface Witch extends Specie {
    boolean canDie = true;

    void enchant();
}

class Hybrid implements Wolf, Vampire {
    @Override
    public void bite() {
        System.out.println("Bit!!!\nNow, You'll die soon. There's no cure for my bite.");
    }
}

class Tribrid extends Hybrid implements Witch {
    boolean canDie = false;
    boolean isStrong = true;
    String name = "Hope Mikaelson";
    @Override
    public void enchant() {
        System.out.println("Silencia.... Incendia....\nEveryone Silenced and caught on fire!!");
    }
}