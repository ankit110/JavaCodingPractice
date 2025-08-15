package exception;

public class AmountMain {

    public static void main(String[] args) {
        AmountAdder.addAmount(new Amount("RUPEE", 200),
                new Amount("DOLLAR", 500));
    }
}
