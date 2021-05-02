package rx;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        Scheduler scheduler = Schedulers.from(service);
        Observable observable= Observable.just("Hi","hey","1","2")
                .subscribeOn(scheduler).doFinally(service::shutdown);

        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());


    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done by:"+ Thread.currentThread().getName());
    }
}
