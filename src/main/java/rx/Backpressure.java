package rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class Backpressure {

    public static void main(String[] args) throws InterruptedException {
//        Flowable.range(1,1000000)
//                .map(e-> {System.out.println("Produced item:"+ e + ":"+ Thread.currentThread().getName());
//                return e;})
//                .observeOn(Schedulers.io())
//                .subscribe(
//                        e->
//                        {
//                            Thread.sleep(100);
//                            System.out.println("Consumed Item:"+ e+ ":" + Thread.currentThread().getName());
//                        }
//                );


        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item:" + e + ":" + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {
                               Subscription subscription;
                               AtomicInteger atomicInteger = new AtomicInteger();
                               @Override
                               public void onSubscribe(Subscription subscription) {
                                   this.subscription = subscription;
                                   System.out.println("Asking for 20 items");
                                   this.subscription.request(20);
                               }
                               @Override
                               public void onNext(Integer integer) {
                                   if (atomicInteger.getAndIncrement() % 20 == 0) {
                                       this.subscription.request(20);
                                       System.out.println("Asking for the next 20 items");
                                   }
                                   System.out.println("consumed" + integer);
                                   try {
                                       Thread.sleep(100);
                                   } catch (InterruptedException e) {
                                       e.printStackTrace();
                                   }
                               }

                               @Override
                               public void onError(Throwable throwable) {
                                   throwable.printStackTrace();
                               }

                               @Override
                               public void onComplete() {
                                   System.out.println("completed");
                               }
                           }

                );

        Thread.sleep(1000000);
    }
}
