package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Switching {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("A","B","C","D");
        observable.concatMap(s->Observable.just(s)
        .delay(ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS
                )).subscribe(System.out::println);

    }
}
