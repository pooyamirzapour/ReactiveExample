package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class FlatConcatMap {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hi");
        Observable.fromIterable(list).
                flatMap(s->Observable.fromArray(s.split("")))
                .subscribe(System.out::println);

        Observable.fromIterable(list).
                concatMap(s->Observable.fromArray(s.split("")))
                .subscribe(System.out::println);

    }
}
