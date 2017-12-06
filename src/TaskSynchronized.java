public class TaskSynchronized implements Runnable {
    /**
     * synchronized methods enable a simple strategy for
     * preventing thread interference and memory consistency
     * errors: if an object is visible to more than one thread,
     * all reads or writes to that object's variables are done
     * through synchronized methods.
     */
    private int number;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            // set(i);
            synchronized (this){
                number = i;
            };
        }
    }

    public synchronized void set(int i) {
        number = i;
    }
}
