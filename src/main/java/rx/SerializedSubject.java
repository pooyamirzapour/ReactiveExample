package rx;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SerializedSubject {
    public static void main(String[] args) {
        Subject<String> subject= PublishSubject.create();

        Subject<String> serialized=subject.toSerialized();

        serialized.subscribe(System.out::println);
        serialized.subscribe(e->System.out.println("element:"+e));

        serialized.onNext("Hi");
        serialized.onNext("Hi2");
        serialized.onNext("Hi3");
        serialized.onComplete();
        serialized.onNext("Hi4");
    }
}
