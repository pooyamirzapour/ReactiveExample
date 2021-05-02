package rx;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.just("Hi","Hey")
                .subscribeOn(Schedulers.computation());
        observable.subscribe(ComputationScheduler::compute);
//        observable.subscribe(e-> compute());
//        observable.subscribe(e-> compute());
//        observable.subscribe(e-> compute());
//        observable.subscribe(e-> compute());
//        observable.subscribe(e-> compute());
//        observable.subscribe(e-> compute());
//        observable.subscribe(e-> compute());

        Thread.sleep(5000);
    }

    private static void compute(String s) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done by:"+ Thread.currentThread().getName());
    }

//    public static void compute() throws InterruptedException {
//        Thread.sleep(1000);
//        System.out.println("Computation Done by:"+ Thread.currentThread().getName());
//    }
}
