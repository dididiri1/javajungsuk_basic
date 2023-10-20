public class Test5 {

    public static void main(String[] args) {

        String str1 = "Kangmin";
        String str2 = "Kangmin";

        String str3 = new String("Kangmin");
        String str4 = str3;

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));

        System.out.println(str3 == str4);
    }
}
