package work4.task2;

public class FormatHandler extends AbstractHandler {
    private static final String[] ALLOWED_FORMATS = {"PDF", "DOCX", "DOC", "TXT"};

    @Override
    public void handle(Document document) {
        System.out.println("\n🔍 FormatHandler: перевірка формату '" + document.getFormat() + "'");

        boolean isValid = false;
        for (String format : ALLOWED_FORMATS) {
            if (format.equalsIgnoreCase(document.getFormat())) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            System.out.println("✅ Формат '" + document.getFormat() + "' прийнятний");
            passToNext(document);
        } else {
            System.out.println("❌ ПОМИЛКА: Формат '" + document.getFormat() + "' не підтримується. Допустимі формати: " + String.join(", ", ALLOWED_FORMATS));
        }
    }
}