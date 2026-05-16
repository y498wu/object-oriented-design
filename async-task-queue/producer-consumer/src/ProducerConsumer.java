import java.util.LinkedList;

public class ProducerConsumer {
    private static final int MAX_SIZE = 5;
    private static final LinkedList<Integer> queue = new LinkedList<>();
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (lock) {
                    while(queue.size() == MAX_SIZE){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    queue.add(i);
                    System.out.println("Produced: " + i + " | queue size: " + queue.size());

                    lock.notifyAll();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (lock) {
                    while(queue.isEmpty()){
                        try{
                            lock.wait();
                        } catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }

                    int val = queue.removeFirst();
                    System.out.println("Consumed: " + val + " | queue size: " + queue.size());

                    lock.notifyAll();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}