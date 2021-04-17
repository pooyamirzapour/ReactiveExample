package observer;

public class ObserverDesignPattern {

    public static void main(String[] args) {

        Book book = new Book("book1","author1","sold out");

        User user = new User("user1",book);
        User user2 = new User("user2",book);

        System.out.println(book.getInStock());

        book.setInStock(" in stock");

    }
}
