package work4.task2;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SubmissionTimeHandler extends AbstractHandler {
    private static final LocalTime WORK_START = LocalTime.of(9, 0);  // 09:00
    private static final LocalTime WORK_END = LocalTime.of(18, 0);   // 18:00

    @Override
    public void handle(Document document) {
        System.out.println("\n🔍 SubmissionTimeHandler: перевірка часу подання " + document.getSubmissionTime());

        LocalTime submissionTime = document.getSubmissionTime().toLocalTime();

        if (submissionTime.isAfter(WORK_START) && submissionTime.isBefore(WORK_END)) {
            System.out.println("✅ Документ подано в робочий час (09:00-18:00)");
            passToNext(document);
        } else {
            System.out.println("❌ ПОМИЛКА: Документ подано поза робочим часом. Робочий час: 09:00-18:00");
        }
    }
}