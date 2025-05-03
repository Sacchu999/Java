import java.util.Comparator;
import java.util.List;

public class Rating {

    static class Product {
        String name;
        double price;
        int rating;

        Product(String name, double price, int rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return name + " | Price: $" + price + " | Rating: " + rating;
        }
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Product A", 100.0, 4),
                new Product("Product B", 50.0, 5),
                new Product("Product C", 50.0, 3),
                new Product("Product D", 150.0, 4)
        );

        // TODO: Sort first by price (ascending), then by rating (descending)
        List<Product> sortedProducts = products.stream()
                .sorted(
                        // Add comparator here
                        Comparator.comparingDouble((Product p) -> p.price)
                                .thenComparing(Comparator.comparingInt((Product p) -> p.rating).reversed())
                )
                .toList();

        sortedProducts.forEach(System.out::println);
    }
}

