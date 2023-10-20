abstract class Animal {
    String a = " is animal";
    abstract void look();

    void show () {
        System.out.println("Zoo");
    }
}

public class Chicken extends Animal {

    Chicken() {
        System.out.println("호출됨!");
        look();
    }
    @Override
    void look() {
        System.out.println("Chicken" + a);
    }

    void display() {
        System.out.println("two wings");
    }
}
