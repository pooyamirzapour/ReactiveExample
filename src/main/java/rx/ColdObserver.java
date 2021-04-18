package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class ColdObserver {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);
        list.add(4);
        observable.subscribe(System.out::println);

    }
}
