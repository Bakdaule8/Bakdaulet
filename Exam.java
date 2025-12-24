import java.util.*;

public class Exam {
    private String subject;
    private List<Question> questions = new ArrayList<>();

    public Exam(String subject) {
        this.subject = subject;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void sortByPoints() {
        questions.sort(Comparator.comparingInt(Question::getPoints));
    }

    public List<Question> filterByPoints(int min) {
        List<Question> result = new ArrayList<>();
        for (Question q : questions) {
            if (q.getPoints() >= min) {
                result.add(q);
            }
        }
        return result;
    }

    public void printExam() {
        System.out.println("Exam: " + subject);
        for (Question q : questions) {
            System.out.println(q);
        }
    }
}
