package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ambiguous {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.interval(1, TimeUnit.SECONDS)
                .map(e->"obs1:" +e).take(10);

        Observable<String> observable2 = Observable.interval(1, TimeUnit.MICROSECONDS)
                .map(e->"obs2:" +e).take(10);

        Observable.amb(Arrays.asList(observable,observable2)).subscribe(System.out::println);

        Thread.sleep(11000);
;    }
}
