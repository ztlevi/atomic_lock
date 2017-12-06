import java.util.Date;

public class Main {

    public static void main(String[] args) {
        TaskAtomic atomicTask = new TaskAtomic();
        TaskLock lockTask = new TaskLock();
        TaskSynchronized syncTask = new TaskSynchronized();

        int numberThreads = 50;
        Thread[] threads = new Thread[numberThreads];
        Date begin, end;

        // lock
        begin = new Date();
        for (int i = 0; i < numberThreads; i++){
            threads[i] = new Thread(lockTask);
            threads[i].start();
        }

        for (int i = 0; i < numberThreads; i++){
            try {
                threads[i].join();
            } catch(InterruptedException  e) {
                e.printStackTrace();
            }
        }
        end = new Date();

        System.out.printf("Main: Lock result : %d\n", (end.getTime()- begin.getTime()));

        // atomic
        begin = new Date();
        for (int i = 0; i < numberThreads; i++){
            threads[i] = new Thread(atomicTask);
            threads[i].start();
        }

        for (int i = 0; i < numberThreads; i++){
            try {
                threads[i].join();
            } catch(InterruptedException  e) {
                e.printStackTrace();
            }
        }
        end = new Date();

        System.out.printf("Main: Atomic result : %d\n", (end.getTime()- begin.getTime()));

        // synchronized
        begin = new Date();
        for (int i = 0; i < numberThreads; i++){
            threads[i] = new Thread(syncTask);
            threads[i].start();
        }

        for (int i = 0; i < numberThreads; i++){
            try {
                threads[i].join();
            } catch(InterruptedException  e) {
                e.printStackTrace();
            }
        }
        end = new Date();

        System.out.printf("Main: Synchronized result : %d\n", (end.getTime()- begin.getTime()));

    }
}
