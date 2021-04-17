package observer;

public class User implements Observer {
    private String name;

    public User(String name , Observable observable) {
        this.name = name;
        observable.subscribeObserver(this);
    }

    @Override
    public void update(String available) {
        System.out.println("User updated:"+ available);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
