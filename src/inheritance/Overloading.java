package inheritance;

public class Overloading {

    // Signature will same but parameters will be different.

    public void doIt(int num) {
        System.out.println(num);
    }

    public void doIt(String str1, String str2) {
        System.out.println(str1 + str2);
    }

}
