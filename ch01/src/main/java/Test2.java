
abstract class Parent {
     int compute(int num) {
        System.out.println("1 call");
        if (num <= 1) {
            return num;
        }
        return compute(num - 1) + compute(num - 2);
    }
}
class Child extends Parent {
    int compute(int num) {
        System.out.println("2 call");
        if (num <= 1) {
            return num;
        }
        return compute(num - 1)
                + compute(num - 3);
    }
}
public class Test2 {

    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.compute(4));
    }
}
