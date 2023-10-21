import java.util.stream.Stream;

public class Ex04 {

    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Kim");
        builder.accept("Lee");
        builder.accept("Song");
        builder.add("Park");
        builder.add("Lee");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }
}
