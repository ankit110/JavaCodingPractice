package objectsAndClasses;

public class CricketScorer {

    int score;

//    public CricketScorer(int score) {
//        this.score = score;
//    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void four() {
        score += 4;
    }

    public void six() {
        score += 6;
    }

}
