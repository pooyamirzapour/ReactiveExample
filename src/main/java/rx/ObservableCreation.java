package rx;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.List;

public class ObservableCreation {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(
                e->{e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();}
        );

        observable.subscribe(System.out::println);

        Observable<Integer> just = Observable.just(1,1,1);
        just.subscribe(System.out::println);

        List<String> list = List.of("John","Jack");
        observable.fromIterable(list).subscribe(System.out::println);
    }
}
