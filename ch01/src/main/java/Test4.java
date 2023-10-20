class Parent2 {
    int a;

    Parent2() {
        a++;
        System.out.println(a);
    }

}

class Child2 extends Parent2 {

    int b = 0;
    Child2(int a) {
        this.b = a;
        System.out.println(a++);
    }
}

public class Test4 {



    public static void main(String[] args) {
        Parent2 pa = new Child2(5);
    }
}
