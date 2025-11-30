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

        System.out.println("\n\n🎯 ТЕСТ 1: УСПІШНА ПЕРЕВІРКА ДОКУМЕНТУ");
        Document validDoc = new Document(
                "Звіт про роботу",
                "PDF",
                "Іван Петренко",
                false,
                LocalDateTime.of(2025, 1, 15, 14, 30)  
        );
        formatHandler.handle(validDoc);

        System.out.println("\n\n🎯 ТЕСТ 2: ПОМИЛКА У ФОРМАТІ ДОКУМЕНТУ");
        Document invalidFormatDoc = new Document(
                "Презентація",
                "EXE", 
                "Марія Коваленко",
                false,
                LocalDateTime.of(2025, 1, 15, 10, 0)
        );
        formatHandler.handle(invalidFormatDoc);

        System.out.println("\n\n🎯 ТЕСТ 3: ПОМИЛКА В АВТОРИЗАЦІЇ");
        Document blockedAuthorDoc = new Document(
                "Важливий документ",
                "DOCX",
                "HACKER", 
                true,
                LocalDateTime.of(2025, 1, 15, 11, 0)
        );
        formatHandler.handle(blockedAuthorDoc);


        System.out.println("\n\n🎯 ТЕСТ 4: ПОМИЛКА В ЧАСІ ПОДАННЯ");
        Document lateDoc = new Document(
                "Нічний звіт",
                "TXT",
                "Олексій Сидоренко",
                false,
                LocalDateTime.of(2025, 1, 15, 20, 0) 
        );
        formatHandler.handle(lateDoc);


        System.out.println("\n\n🎯 ТЕСТ 5: КОНФІДЕНЦІЙНИЙ ДОКУМЕНТ");
        Document confidentialDoc = new Document(
                "Секретний договір",
                "PDF",
                "Андрій Мельник",
                true, 
                LocalDateTime.of(2025, 1, 15, 15, 45)
        );
        formatHandler.handle(confidentialDoc);
    }
}
