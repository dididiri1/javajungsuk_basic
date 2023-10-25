import java.util.ArrayList;
import java.util.List;

public class Ex01 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C");
        list.add("React");


        list.stream().forEach((String str) -> {System.out.println(str);} );
        list.stream().forEach(str -> System.out.println(str) );  // () 파라미터 생략 가능 , {} 실행문 생략 가능
        list.stream().forEach(System.out::println);
    }
}
