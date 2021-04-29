package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Caching {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .cache() ;

        observable.subscribe(e-> System.out.println("obs1:"+ e));

        Thread.sleep(3000);
        observable.subscribe(e-> System.out.println("obs2:"+ e));

        Thread.sleep(2000);
    }
}
