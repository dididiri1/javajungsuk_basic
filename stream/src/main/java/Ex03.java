import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex03 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Lee", "Kim", "Park", "Hong", "Choi", "Song");

        Stream<String> stream = list.stream(); // Stream 생성
        System.out.println(stream.count()); // Stream 사용
        //stream.forEach(name -> System.out.println(name));
        stream.forEach(System.out::println); // Exception 발생
    }
}
