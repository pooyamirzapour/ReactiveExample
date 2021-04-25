package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeConcat {

    public static void main(String[] args) throws InterruptedException {
//        Observable <String> observable = Observable.just("A","B","C");
//        Observable <String> observable2 = Observable.just("D","E","C");
//
//        Observable.merge(observable,observable2).subscribe(System.out::println);
//        Observable.concat(observable,observable2).subscribe(System.out::println);
//
//        Observable<String> source1= Observable.interval(1, TimeUnit.SECONDS).map(e->"source1:"+e);
//        Observable<String> source2= Observable.interval(1, TimeUnit.MILLISECONDS).map(e->"source2:"+e);
//
//        //Observable.merge(source1,source2).subscribe(e-> System.out.println("Received:" + e));
//        Observable.concat(source1,source2).subscribe(e-> System.out.println("Received:" + e));
        Observable.concat(
                Observable.interval(1, TimeUnit.SECONDS).map(id -> "A" + id),
                Observable.interval(1, TimeUnit.SECONDS).map(id -> "B" + id))
                .subscribe(System.out::println);

        Observable.merge(
                Observable.interval(1, TimeUnit.SECONDS).map(id -> "A" + id),
                Observable.interval(1, TimeUnit.SECONDS).map(id -> "B" + id))
                .subscribe(System.out::println);


        Thread.sleep(10000);

    }
}
