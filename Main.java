import java.sql.*;
import java.util.Scanner;

public class Main {

    static String url = "jdbc:postgresql://localhost:5432/exam";
    static String user = "postgres";
    static String password = "baha2008.a";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to Online Exam DB!");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- ONLINE EXAM SYSTEM ---");
                System.out.println("1. Add Exam");
                System.out.println("2. Add Question");
                System.out.println("3. Show Exams & Questions");
                System.out.println("4. Add Candidate");
                System.out.println("5. Show Candidates");
                System.out.println("6. Update Candidate Score");
                System.out.println("7. Delete Candidate");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 0) break;

                switch (choice) {
                    case 1 -> addExam(con, sc);
                    case 2 -> addQuestion(con, sc);
                    case 3 -> showAll(con);
                    case 4 -> addCandidate(con, sc);
                    case 5 -> showCandidates(con);
                    case 6 -> updateCandidate(con, sc);
                    case 7 -> deleteCandidate(con, sc);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------- EXAM (INSERT) ----------
    static void addExam(Connection con, Scanner sc) throws Exception {
        System.out.print("Exam subject: ");
        String subject = sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO exam(subject, questions) VALUES (?, 0)");
        ps.setString(1, subject);
        ps.executeUpdate();

        System.out.println("Exam added!");
    }

    // ---------- QUESTION (INSERT) ----------
    static void addQuestion(Connection con, Scanner sc) throws Exception {
        System.out.print("Question text: ");
        String text = sc.nextLine();

        System.out.print("Points: ");
        int points = sc.nextInt();

        System.out.print("Exam ID: ");
        int examId = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO question(text, points, exam_id) VALUES (?, ?, ?)");
        ps.setString(1, text);
        ps.setInt(2, points);
        ps.setInt(3, examId);
        ps.executeUpdate();

        System.out.println("Question added!");
    }

    // ---------- SELECT (JOIN) ----------
    static void showAll(Connection con) throws Exception {
        String sql = """
                SELECT e.subject, q.id, q.text, q.points
                FROM exam e
                LEFT JOIN question q ON q.exam_id = e.id
                ORDER BY e.id
                """;

        ResultSet rs = con.createStatement().executeQuery(sql);

        System.out.println("\n--- EXAMS & QUESTIONS ---");
        while (rs.next()) {
            System.out.println(
                    rs.getString("subject") + " | " +
                            rs.getInt("id") + " | " +
                            rs.getString("text") + " (" +
                            rs.getInt("points") + " pts)"
            );
        }
    }

    // ---------- CANDIDATE (INSERT) ----------
    static void addCandidate(Connection con, Scanner sc) throws Exception {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Score: ");
        double score = sc.nextDouble();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO candidate(name, age, score) VALUES (?, ?, ?)");
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setDouble(3, score);
        ps.executeUpdate();

        System.out.println("Candidate added!");
    }

    // ---------- CANDIDATE (SELECT) ----------
    static void showCandidates(Connection con) throws Exception {
        ResultSet rs = con.createStatement().executeQuery(
                "SELECT * FROM candidate");

        System.out.println("\n--- CANDIDATES ---");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getInt("age") + " | " +
                            rs.getDouble("score")
            );
        }
    }

    // ---------- CANDIDATE (UPDATE) ----------
    static void updateCandidate(Connection con, Scanner sc) throws Exception {
        System.out.print("Candidate ID: ");
        int id = sc.nextInt();

        System.out.print("New score: ");
        double score = sc.nextDouble();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE candidate SET score=? WHERE id=?");
        ps.setDouble(1, score);
        ps.setInt(2, id);
        ps.executeUpdate();

        System.out.println("Score updated!");
    }

    // ---------- CANDIDATE (DELETE) ----------
    static void deleteCandidate(Connection con, Scanner sc) throws Exception {
        System.out.print("Candidate ID to delete: ");
        int id = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM candidate WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Candidate deleted!");
    }
}
