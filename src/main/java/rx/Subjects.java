package rx;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Subjects {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> observable1 = Observable.just(1,2,3)
                .subscribeOn(Schedulers.computation());
        Observable<Integer> observable2 = Observable.just(10,20,30)
                .subscribeOn(Schedulers.computation());

//        observable1.subscribe(System.out::println);
//        observable2.subscribe(System.out::println);

        Subject<Object> subject= PublishSubject.create();
        subject.subscribe(System.out::println);
        observable1.subscribe(subject);
        observable1.subscribe(subject);
        observable2.subscribe(subject);

        Thread.sleep(13000);
    }
}
