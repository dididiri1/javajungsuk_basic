import java.util.ArrayList;
import java.util.List;

public class Ex05 {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Lee", 67));
        customers.add(new Customer("Choi", 19));
        customers.add(new Customer("Kim", 33)); // 중복 데이터

        customers.stream()
                .filter(customer -> customer.getAge() > 30)
                .forEach(System.out::println);

        System.out.println();

        customers.stream()
                .filter(customer -> customer.getAge() > 30)
                .distinct()
                .forEach(System.out::println);
    }
}
