package rx;

import io.reactivex.rxjava3.core.Observable;

public class ObserverCreation {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Jack","John","Joe");
        System.out.println();
        observable.subscribe(System.out::println);
        System.out.println();
        observable.subscribe(System.out::println,Throwable::printStackTrace,()-> System.out.println("Completed"));
    }
}
