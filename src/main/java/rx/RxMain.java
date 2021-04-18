package rx;

import io.reactivex.rxjava3.core.Observable;

public class RxMain {

    public static void main(String[] args) {

        Observable<String> source = Observable.create(
                e -> {
                    e.onNext("Element1");
                    e.onNext("Element2");
                }
        );
        source.subscribe(e -> System.out.println("observer1:" + e));

    }
}
