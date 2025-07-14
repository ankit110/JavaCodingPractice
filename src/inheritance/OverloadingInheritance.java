package inheritance;

public class OverloadingInheritance extends Overloading {

    public void doIt(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public void doIt(String str) {
        System.out.println(str);
    }
}
