package petitProgrammes.src.package1;

public class fibonacci {

    public static void suite() {
        int fibo[];
        boolean tour = true;
        fibo = new int[10];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 0; i < 10; i++) {
            if (tour) {
                fibo[0] += fibo[1];
                System.out.println(fibo[0]);
                tour = false;
            } else {
                fibo[1] += fibo[0];
                System.out.println(fibo[1]);
                tour = true;
            }
        }
    }

    public static void main(final String[] args) {
        suite();
    }

}