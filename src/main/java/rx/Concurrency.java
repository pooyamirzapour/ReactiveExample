package rx;


import io.reactivex.rxjava3.core.Observable;

public class Concurrency {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(

                e -> {
                    new Thread(
                            () ->
                            {
                                e.onNext("Hi");
                                e.onNext("Hey");
                            }).start();
                }
        );

        observable.subscribe(e -> System.out.println("Observer1:" + e + " " + Thread.currentThread().getName()));
        observable.subscribe(e -> System.out.println("Observer2:" + e + " " + Thread.currentThread().getName()));
    }
}
