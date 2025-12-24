import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Candidate name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Score: ");
        double score = sc.nextDouble();

        Candidate c = new Candidate(name, age, score);

        Exam exam = new Exam("Online Java Exam");
        exam.addQuestion(new Question("2+2=?", 5));
        exam.addQuestion(new Question("OOP principles?", 10));

        exam.sortByPoints();
        exam.printExam();

        System.out.println("Candidate info: " + c);
    }
}
