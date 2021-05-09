package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Buffering {

    public static void main(String[] args) throws InterruptedException {
//        Observable.range(1,30)
//                .buffer(3)
//                .subscribe(System.out::println);

//        Observable.interval(500, TimeUnit.MILLISECONDS)
//                .buffer(2,TimeUnit.SECONDS,2).subscribe(System.out::println);
//
//        Thread.sleep(10000);

        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

        Observable.interval(1000,TimeUnit.MILLISECONDS)
                .window(interval).subscribe(System.out::println);

        Thread.sleep(5000);


    }
}
