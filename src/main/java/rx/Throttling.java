package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Throttling {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(

                e ->
                {
                    e.onNext("A");
                    Thread.sleep(200);
                    e.onNext("B");
                    Thread.sleep(100);
                    e.onNext("C");
                    Thread.sleep(300);
                    e.onNext("D");
                    Thread.sleep(400);
                    e.onNext("E");
                    Thread.sleep(800);
                    e.onNext("F");
                    Thread.sleep(900);
                    e.onNext("X");
                    Thread.sleep(600);
                    e.onNext("Y");
                    Thread.sleep(1000);
                    e.onNext("Z");
                    e.onComplete();
                }
        );

        observable
                //.throttleFirst(1, TimeUnit.SECONDS)
                //.sample(1, TimeUnit.SECONDS) //last
                .debounce(700, TimeUnit.MILLISECONDS) //with timeout
                .subscribe(item -> System.out.println("OnNext:" + item),
                Throwable::printStackTrace,
                () -> System.out.println("OnComplete:")
        );

    }
}
