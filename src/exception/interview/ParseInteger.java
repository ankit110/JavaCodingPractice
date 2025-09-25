package exception.interview;

public class ParseInteger {

    public int parseInteger(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch(NumberFormatException ex) {
            System.out.println("Invalid input:- " + str);
            return -1;
        }

        return number;
    }
}
