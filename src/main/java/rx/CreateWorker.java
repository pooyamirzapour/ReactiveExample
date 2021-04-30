package rx;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicReference;

public class CreateWorker {

    public static void main(String[] args) {
        Scheduler scheduler = Schedulers.newThread();
        Scheduler.Worker worker = scheduler.createWorker();
        AtomicReference<String> result = null;
        worker.schedule(()->
        {
             result.set("first action");

        });

       // Assert.assertTrue(result.equals("first action"));

    }
}
