import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapUsingOptional {

    public static void main(String[] args) {

//  You are given a list of usernames, some of which may be null or empty. Clean them by:
//        * Wrapping each name in Optional
//        * Trimming it and converting it to uppercase
//        * Filtering out blank or null values
//        * Collecting the final names

        List<String> rawNames = Arrays.asList("  alice ", null, "BOB", "  ", "charlie");

        List<String> names = rawNames.stream()
                .map(Optional::ofNullable)
                .flatMap(Optional::stream)
                .map(String::trim)
                .filter(n -> !n.isBlank())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
