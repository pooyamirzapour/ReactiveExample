package rx;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {

    public static void main(String[] args) throws InterruptedException {
         Observable.just("Pa","Ta","Ka","Po")
                .subscribeOn(Schedulers.computation())
                .map(e->e.toUpperCase())
                 .doOnNext(e-> System.out.println(Thread.currentThread().getName()))
                .subscribeOn(Schedulers.newThread())
                .filter(e->e.startsWith("P"))
                .subscribe(e->print(e));

         Thread.sleep(5000);
    }

    public static void print(String e) {
        System.out.println(e+ " " + Thread.currentThread().getName());
    }
}
