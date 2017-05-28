package Objects;

import java.io.Serializable;

/**
 * Created by jame on 4/16/17.
 */
public class Result implements Serializable{
    private String URL;
    private int score;

    public Result(String url, int score) {
        this.URL = url;
        this.score = score;
    }
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void add() {
        this.score += 1;
    }
}
