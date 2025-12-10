public class Main {
    public static void main(String[] args) {

        // Create Question objects
        Question q1 = new Question("2+2=?", "4", 5);
        Question q2 = new Question("Capital of France?", "Paris", 5);

        // Print questions
        q1.printQuestion();
        q2.printQuestion();

        // Create Candidate objects
        Candidate c1 = new Candidate("Bek", 18, 85.5);
        Candidate c2 = new Candidate("Dias", 19, 90.0);

        // Print candidates
        c1.printInfo();
        c2.printInfo();

        // Compare candidates (scores)
        System.out.println("Is c1 score equal to c2? "
                + (c1.getScore() == c2.getScore()));

        // Create Exam object
        Exam exam = new Exam("Java Programming", 60, c1);

        // Print exam info
        exam.printExamInfo();
    }
}
