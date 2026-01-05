import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Exam exam = new Exam("OOP Exam");

        System.out.print("Question text: ");
        String text = sc.nextLine();

        System.out.print("Points: ");
        int points = sc.nextInt();

        exam.addQuestion(new Question(text, points));
        exam.printExam();
    }
}