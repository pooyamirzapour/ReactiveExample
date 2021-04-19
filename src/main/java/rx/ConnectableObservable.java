package rx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservable {
    public static void main(String[] args) throws InterruptedException {
        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<Long> observable
                = Observable.interval(1, TimeUnit.SECONDS).publish();

        observable.connect();
        observable.subscribe(System.out::println);
       // Thread.sleep(5000);
        observable.subscribe(System.out::println);
        //Thread.sleep(5000);
    }
}
