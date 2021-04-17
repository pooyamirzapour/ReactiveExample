package observer;

public interface SubjectLibrary {
    void subscribeObserver(Observer observer);
    void unsubscribeObserver(Observer observer);
    void notifyObserver(Observer observer);
}
