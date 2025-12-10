public class Exam {
    private String subject;
    private int duration;
    private Candidate candidate;

    public Exam(String subject, int duration, Candidate candidate) {
        this.subject = subject;
        this.duration = duration;
        this.candidate = candidate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public void printExamInfo() {
        System.out.println("Exam subject: " + subject);
        System.out.println("Duration: " + duration + " minutes");
        System.out.print("Candidate: ");
        candidate.printInfo();
    }
}
