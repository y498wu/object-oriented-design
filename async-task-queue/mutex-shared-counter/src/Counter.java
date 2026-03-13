public class Counter {
    static int count = 0;

    private static synchronized void addTenThousand(){
        for (int i = 0; i < 100000; i++){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(Counter::addTenThousand);

        Thread t2 = new Thread(Counter::addTenThousand);

        t1.start();
        t2.start();
        t1.join();  // wait for t1 to finish
        t2.join();  // wait for t2 to finish

        System.out.println("Expected: 200000");
        System.out.println("Got:      " + count);
    }
}