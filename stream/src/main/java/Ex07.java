import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex07 {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Lee", 67));
        customers.add(new Customer("Choi", 19));

        List<String> names = customers.stream()
                .map(Customer::getName)
                .collect(Collectors.toList());

        names.stream().forEach(System.out::println);

        System.out.println();

        customers.stream()
                .map(Customer::getName)
                .forEach(System.out::println);
    }
}
