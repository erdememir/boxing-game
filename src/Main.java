public class Main {
    public static void main(String[] args) {
        Fighter khabib = new Fighter("Khabib", 7,100,88,35);
        Fighter gregor = new Fighter("McGregor", 9, 100, 85,20);
        Match m = new Match(khabib, gregor,85,100);
        m.run();
    }
}