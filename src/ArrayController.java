import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayController {
    private ArrayList<Scores> scores;

    public static ArrayController instance;

    public ArrayController(){
        this.scores = new ArrayList<>();
        this.instance = this;
    }

    public int getIndex(String n){
        int res = -1;
        for(int i = 0 ; i< scores.size();i++){
            if(scores.get(i).getName().equals(n)){
                res = i;
                break;
            }
        }
        return res;
    }

    public ArrayList<Scores> getScores() {
        return scores;
    }

    public void create(){
        this.sortt();
        try {
            PrintStream ps = new PrintStream(new File("scores.bat"));
            PrintStream def = System.out;
            System.setOut(ps);
            for(int i = 0 ; i < scores.size();i++){
                System.out.println(scores.get(i).getName() + ":" + scores.get(i).getScore() + " : " + scores.get(i).getDate() +"\n");
            }
            System.setOut(def);
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sortt(){
        Collections.sort(scores, Comparator.comparing(Scores::getScore));
        Collections.reverse(scores);
    }


}
