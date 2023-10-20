import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex01 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Lee", "Park", "Kim");

        // 기존
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        // 확장 for문
        for (String s : list) {
            System.out.println(s);
        }

        // Stream
        list.stream().forEach(s -> System.out.println(s));
    }
}
