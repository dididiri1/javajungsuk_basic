import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02 {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Lee", 67));
        customers.add(new Customer("Choi", 19));

        List<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getAge() > 30) {
                list.add(customer);
            }
        } // age 30 > 추출

        Collections.sort(list); // age 정렬

        List<String> result = new ArrayList<>();
        for (Customer customer : list) {
            result.add(customer.getName());
        }

        for (String name : result) {
            System.out.println(name);
        }

        List<String> customersNames = customers.stream()
                .filter(customer -> customer.getAge() > 30) // 조건 필터링
                .sorted(Comparator.comparing(Customer::getAge).reversed())  // 내림차순 정렬
                .map(Customer::getName)  // 추출데이터 맵핑
                .collect(Collectors.toList()); // 반환 형태

        for (String name : customersNames) {
            System.out.println(name);
        }
    }
}
