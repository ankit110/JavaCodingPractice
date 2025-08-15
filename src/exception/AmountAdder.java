package exception;

public class AmountAdder {

    static Amount addAmount(Amount amount1, Amount amount2) {
        if(!amount1.currency.equals(amount2.currency)) {
            throw new RuntimeException("Currency Mismatch");
//            throw new Exception("Currency Mismatch"); // Compilation Error(checked Exception)
                                                // Whoever method is calling needs to handle this exception or throws it.
        }
        return new Amount(amount1.currency, amount1.amount + amount2.amount);
    }
}
