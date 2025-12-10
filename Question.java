public class Question {
    private String text;
    private String correctAnswer;
    private int points;

    public Question(String text, String correctAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void printQuestion() {
        System.out.println("Question: " + text);
    }
}
