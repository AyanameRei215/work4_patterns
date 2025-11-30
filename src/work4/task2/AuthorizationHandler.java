package work4.task2;

public class AuthorizationHandler extends AbstractHandler {
    private static final String[] BLOCKED_AUTHORS = {"HACKER", "SPAMMER", "UNKNOWN"};

    @Override
    public void handle(Document document) {
        System.out.println("\n🔍 AuthorizationHandler: перевірка автора '" + document.getAuthor() + "'");

        if (document.getAuthor() == null || document.getAuthor().trim().isEmpty()) {
            System.out.println("❌ ПОМИЛКА: Автор документа не вказаний");
            return;
        }

        boolean isBlocked = false;
        for (String blocked : BLOCKED_AUTHORS) {
            if (blocked.equalsIgnoreCase(document.getAuthor())) {
                isBlocked = true;
                break;
            }
        }

        if (isBlocked) {
            System.out.println("❌ ПОМИЛКА: Автор '" + document.getAuthor() + "' заблокований в системі");
        } else {
            System.out.println("✅ Автор '" + document.getAuthor() + "' авторизований");
            passToNext(document);
        }
    }
}