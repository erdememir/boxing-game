public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    boolean turn = false;
    boolean firstStat = true;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        if (checkWeight()) {
            turn = isFirst();
            while (this.f1.hp > 0 && this.f2.hp > 0) {
                System.out.println("");
                System.out.println("=====YENİ TUR=====");
                if (turn) {
                    this.f2.hp = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.hp = this.f2.hit(f1);
                } else {
                    this.f1.hp = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.hp = this.f1.hit(f2);
                }
                if (isWin()) {
                    break;
                }
                turn = !turn;
                printScore();
            }

        } else {
            System.out.println("Sporcuların ağırlıkları birbiriyle uyumlu değil.");
        }
    }

    boolean checkWeight() {
        return (this.f1.weight >= this.minWeight && this.f1.weight <= this.maxWeight) && (this.f2.weight >= this.minWeight && this.f2.weight <= this.maxWeight);
    }

    boolean isWin() {
        if (this.f1.hp == 0) {
            System.out.println("Maçın kazananı: " + this.f2.name);
            return true;
        } else if (this.f2.hp == 0) {
            System.out.println("Maçın kazananı: " + this.f1.name);
            return true;
        }
        return false;
    }

    boolean isFirst() {
        double randomValue = Math.random() * 100;
        return randomValue <= 50;
    }

    void printScore() {
        System.out.println("---------------");
        System.out.println(this.f1.name + " Kalan can: " + this.f1.hp);
        System.out.println(this.f2.name + " Kalan can: " + this.f2.hp);
    }
}
