import java.util.List;

public class Map {

    // Sample data classes
    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    static class Author {
        String name;

        Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Book {
        String title;
        Author author;

        Book(String title, Author author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public Author getAuthor() {
            return author;
        }
    }

    static class UserDTO {
        String username;

        UserDTO(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "UserDTO{" + "username='" + username + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        mapProductPrices();
        mapBookAuthors();
        mapStringToLengths();
        mapNamesToDTOs();
    }

    // TASK 1: Map Product prices to prices with tax
    static void mapProductPrices() {
        List<Product> products = List.of(
                new Product("Pen", 10.0),
                new Product("Notebook", 50.0),
                new Product("Eraser", 5.0)
        );
        products.stream()
                .map(p -> p.price += (p.price * 18) / 100)
                .forEach(System.out::println);
        // TODO: Use map() to apply 18% tax and print updated prices
    }

    // TASK 2: Extract author names from list of books
    static void mapBookAuthors() {
        List<Book> books = List.of(
                new Book("Java 101", new Author("Alice")),
                new Book("Streams Deep Dive", new Author("Bob"))
        );
        books.stream()
                .map(b -> b.getAuthor().name)
                .forEach(System.out::println);
        // TODO: Use map() to extract author names and print them
    }

    // TASK 3: Convert string list to uppercase and then to their lengths
    static void mapStringToLengths() {
        List<String> words = List.of("apple", "banana", "cherry");

        words.stream()
                .map(String::toUpperCase)
                .map(String::length)
                .forEach(System.out::println);
        // TODO: Use chained map() calls to get lengths of uppercase words
    }

    // TASK 4: Map names to UserDTO objects
    static void mapNamesToDTOs() {
        List<String> names = List.of("john", "jane", "mike");

        names.stream()
                .map(UserDTO::new)
                .forEach(System.out::println);
        // TODO: Convert each string to a UserDTO and print the list
    }
}

