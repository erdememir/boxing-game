public class Fighter {
    String name;
    int dmg;
    int hp;
    int weight;
    int dodge;

    Fighter(String name, int dmg, int hp, int weight, int dodge) {
        this.name = name;
        this.dmg = dmg;
        this.hp = hp;
        this.weight = weight;
        this.dodge = dodge;
    }

    int hit(Fighter foe) {
        System.out.println("---------------");
        System.out.println(this.name + " ==> " + foe.name + " " + this.dmg + " hasar vurdu.");
        if (foe.isDodge()) {
            System.out.println(foe.name + " gelen hasarı savuşturdu.");
            return foe.hp;
        }
        if (foe.hp - this.dmg < 0) {
            return 0;
        }
        return foe.hp - this.dmg;
    }

    boolean isDodge() {
        double randomValue = Math.random() * 100;
        return randomValue <= this.dodge;
    }
}
