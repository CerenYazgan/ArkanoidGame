import java.util.Date;

public class Scores implements Comparable {
    private String name;
    private int score;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Scores(String n, int t){
        this.name = n;
        this.score = t;
    }

    @Override
    public int compareTo(Object o) {
        if(((Scores) o).name.equals(this.name)){
            return 0;
        }
        else{
            return -1;
        }
    }
}
