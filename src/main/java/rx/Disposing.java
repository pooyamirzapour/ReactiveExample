package rx;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Disposing {

    private static final CompositeDisposable disp=new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        Disposable subscribe = observable.subscribe(w -> System.out.println("element1:" + w));
        Disposable subscribe1 = observable.subscribe(w -> System.out.println("element2:" + w));

        disp.addAll(subscribe,subscribe1);
        disp.dispose();
        Thread.sleep(10000);

    }
}
