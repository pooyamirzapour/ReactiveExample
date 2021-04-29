package rx;


import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source1 = Observable.interval(50, TimeUnit.MILLISECONDS).take(10);
        Observable<Long> source2 = Observable.interval(2, TimeUnit.SECONDS).take(10);

//        Observable.zip(source1,source2,(e1,e2)->"source1:"+ e1+" "+ "source2:"+ e2)
//        .subscribe(System.out::println);
        Observable.combineLatest(source1,source2,(e1,e2)->"source1:"+ e1+" "+ "source2:"+ e2)
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
