package rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    public Employee(String name, Integer rate) {
        this.name = name;
        this.rate = rate;
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee   = new Employee("A",1);
        Employee employee2   = new Employee("B",1);
        Employee employee3   = new Employee("C",2);
        Employee employee4   = new Employee("D",2);
        list.add(employee);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);

        Observable<Employee> observable = Observable.fromIterable(list);
        observable.groupBy(e->e.rate).flatMapSingle(e->e.toMultimap(k->k.getRate(),v->v.getName())).subscribe(System.out::println);

        Observable<Employee> observable2 = Observable.fromIterable(list);
        observable.groupBy(e->e.rate).flatMapSingle(e->e.toList()).subscribe(System.out::println);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }

    private String name;
    private Integer rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
