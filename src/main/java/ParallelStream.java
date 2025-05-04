import java.util.Comparator;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {

        // Simple Parallel stream example
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Alice2", "Bob2", "Charlie2", "David3", "Eve5", "Charlie3", "David3", "Eve3");

        names.parallelStream()
                .forEach(name -> {
                    System.out.println(Thread.currentThread().getName() + " - " + name);
                });

        // To check the number of threads/cores in system
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available CPU cores: " + cores);

        // To work with custom objects using Parallel streams (Complex example)
        List<ParallelSort.Product> products = List.of(
                new ParallelSort.Product("A", 10.0),
                new ParallelSort.Product("B", 5.0),
                new ParallelSort.Product("C", 20.0),
                new ParallelSort.Product("D", 15.0)
        );

        products.parallelStream()
                .sorted(Comparator.comparingDouble(p -> p.price))
                .forEachOrdered(System.out::println); // ordered to keep sort result readable
    }

    public class ParallelSort {
        static class Product {
            String name;
            double price;

            Product(String name, double price) {
                this.name = name;
                this.price = price;
            }

            @Override
            public String toString() {
                return name + " - $" + price;
            }
        }

    }

}