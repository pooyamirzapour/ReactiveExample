package observer;

import java.util.ArrayList;
import java.util.List;

public class Book implements Observable {

    private String name;
    private String author;
    private String inStock;
    private List<Observer> observerList=new ArrayList<>();

    public Book(String name, String author, String inStock) {
        this.name = name;
        this.author = author;
        this.inStock = inStock;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unsubscribeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer1 : observerList) {
            observer1.update("Hey"+this.inStock);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        notifyObserver();
    }
}
