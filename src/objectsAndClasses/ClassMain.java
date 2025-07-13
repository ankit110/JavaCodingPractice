package objectsAndClasses;

public class ClassMain {

    public static void main(String []args) {
        CricketScorer scorer = new CricketScorer();

        System.out.println(scorer.getScore()); // State of scorer is (score => 0)

        scorer.six();

        System.out.println(scorer.getScore()); // State of scorer is (score => 6)

        scorer.four();

        System.out.println(scorer.getScore()); // State of scorer is (score => 10)
    }
}
