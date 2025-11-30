package work4.task2;

import java.time.LocalDateTime;

public class Document {
    private String name;
    private String format;
    private String author;
    private boolean confidential;
    private LocalDateTime submissionTime;

    public Document(String name, String format, String author, boolean confidential, LocalDateTime submissionTime) {
        this.name = name;
        this.format = format;
        this.author = author;
        this.confidential = confidential;
        this.submissionTime = submissionTime;
        System.out.println("Створено документ: " + name + " (формат: " + format + ", автор: " + author + ")");
    }

    public String getName() { return name; }
    public String getFormat() { return format; }
    public String getAuthor() { return author; }
    public boolean isConfidential() { return confidential; }
    public LocalDateTime getSubmissionTime() { return submissionTime; }

    @Override
    public String toString() {
        return "Документ: " + name +
                ", Формат: " + format +
                ", Автор: " + author +
                ", Конфіденційний: " + confidential +
                ", Час подання: " + submissionTime;
    }
}