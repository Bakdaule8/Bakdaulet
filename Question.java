import java.util.Objects;

public class Question {
    private String text;
    private int points;

    public Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return text + " (" + points + " points)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question q = (Question) o;
        return text.equals(q.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
