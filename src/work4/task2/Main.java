package work4.task2;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЛАНЦЮЖКА ОБРОБНИКІВ ДОКУМЕНТІВ ===\n");


        System.out.println("📋 СТВОРЕННЯ ЛАНЦЮЖКА ОБРОБНИКІВ:");
        Handler formatHandler = new FormatHandler();
        Handler authHandler = new AuthorizationHandler();
        Handler confidentialityHandler = new ConfidentialityHandler();
        Handler timeHandler = new SubmissionTimeHandler();


        formatHandler.setNextHandler(authHandler);
        authHandler.setNextHandler(confidentialityHandler);
        confidentialityHandler.setNextHandler(timeHandler);

        // Тест 1: Успішна перевірка документа
        System.out.println("\n\n🎯 ТЕСТ 1: УСПІШНА ПЕРЕВІРКА ДОКУМЕНТУ");
        Document validDoc = new Document(
                "Звіт про роботу",
                "PDF",
                "Іван Петренко",
                false,
                LocalDateTime.of(2024, 1, 15, 14, 30)  // Робочий час
        );
        formatHandler.handle(validDoc);

        // Тест 2: Помилка в форматі
        System.out.println("\n\n🎯 ТЕСТ 2: ПОМИЛКА У ФОРМАТІ ДОКУМЕНТУ");
        Document invalidFormatDoc = new Document(
                "Презентація",
                "EXE",  // Недопустимий формат
                "Марія Коваленко",
                false,
                LocalDateTime.of(2024, 1, 15, 10, 0)
        );
        formatHandler.handle(invalidFormatDoc);

        // Тест 3: Помилка в авторизації
        System.out.println("\n\n🎯 ТЕСТ 3: ПОМИЛКА В АВТОРИЗАЦІЇ");
        Document blockedAuthorDoc = new Document(
                "Важливий документ",
                "DOCX",
                "HACKER",  // Заблокований автор
                true,
                LocalDateTime.of(2024, 1, 15, 11, 0)
        );
        formatHandler.handle(blockedAuthorDoc);

        // Тест 4: Помилка в часі подання
        System.out.println("\n\n🎯 ТЕСТ 4: ПОМИЛКА В ЧАСІ ПОДАННЯ");
        Document lateDoc = new Document(
                "Нічний звіт",
                "TXT",
                "Олексій Сидоренко",
                false,
                LocalDateTime.of(2024, 1, 15, 20, 0)  // Поза робочим часом
        );
        formatHandler.handle(lateDoc);

        // Тест 5: Конфіденційний документ
        System.out.println("\n\n🎯 ТЕСТ 5: КОНФІДЕНЦІЙНИЙ ДОКУМЕНТ");
        Document confidentialDoc = new Document(
                "Секретний договір",
                "PDF",
                "Андрій Мельник",
                true,  // Конфіденційний
                LocalDateTime.of(2024, 1, 15, 15, 45)
        );
        formatHandler.handle(confidentialDoc);
    }
}
