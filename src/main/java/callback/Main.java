package callback;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is a main thread");

        Runnable runnable = ()-> {

            try {
                new Main().runningAsync(new CallBack() {

                    @Override
                    public void pushData(String data) {
                        System.out.println("data pushed");
                    }

                    @Override
                    public void pushComplete() {
                        System.out.println("data completed");
                    }

                    @Override
                    public void pushError(Exception e) {
                        System.out.println("An exception occurred:"+ e);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        System.out.println("In main thread continue");

        Thread t = new Thread(runnable);
        t.start();

    }

    public void runningAsync(CallBack callback) throws InterruptedException {
        System.out.println("In separate thread");
        Thread.sleep(2000);
        callback.pushData("push data");
        Thread.sleep(2000);
        callback.pushData("push data1");
        Thread.sleep(2000);
        callback.pushData("push data2");
        callback.pushComplete();
        callback.pushError(new RuntimeException());
    }
}
