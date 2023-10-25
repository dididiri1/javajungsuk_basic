import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex06 {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Lee", 67));
        customers.add(new Customer("Choi", 19));

        customers.stream()
                .sorted(Comparator.comparing(Customer::getAge))
                .sorted(Comparator.comparing(Customer::getAge).reversed())
                .forEach(System.out::println);
    }
}
