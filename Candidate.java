import java.util.Objects;

public class Candidate extends Person {
    private double score;

    public Candidate(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String getRole() {
        return "Candidate";
    }

    @Override
    public String toString() {
        return name + " (" + age + "), score=" + score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate)) return false;
        Candidate that = (Candidate) o;
        return Double.compare(that.score, score) == 0 &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
