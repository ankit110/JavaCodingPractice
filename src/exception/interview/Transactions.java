package exception.interview;

import exception.customexceptionclasses.TransactionFailedException;

public class Transactions {

    public static String processTransaction(double amount) throws TransactionFailedException {
        try {
            int result = 10/0; // simulate failure
        } catch(ArithmeticException ex) {
            // ✅ Wrap the original exception inside a custom one
            throw new TransactionFailedException("Transaction failed.", ex);
        }

        return "transaction Successful";
    }
}
