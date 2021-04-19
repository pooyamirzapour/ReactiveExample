package rx;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;

public class Variant {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Jack","Joe");
        observable.first("First").subscribe(System.out::println);

        Single.just("Jack").subscribe(System.out::println);

        Observable<String> observable2 = Observable.empty();
        observable2.firstElement().subscribe(System.out::println);

        Completable completable = Completable.complete();
        completable.subscribe(()-> System.out.println("Completed"));

        Completable.fromRunnable(()-> System.out.println("executing")).subscribe(()-> System.out.println("executed"));

    }
}
