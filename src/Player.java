public class Player {
    private int lives;
    private int scores;
    private int level;
    public static Player instance;
    public boolean over;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Player(){
        this.instance = this;
        this.lives = 3;
        this.scores = 0;
        this.level = 1;
        this.over = false;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
