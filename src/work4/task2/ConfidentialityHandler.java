package work4.task2;

public class ConfidentialityHandler extends AbstractHandler {

    @Override
    public void handle(Document document) {
        System.out.println("\n🔍 ConfidentialityHandler: перевірка конфіденційності");

        if (document.isConfidential()) {
            System.out.println("⚠️  УВАГА: Документ '" + document.getName() + "' є конфіденційним");
        } else {
            System.out.println("✅ Документ не є конфіденційним");
        }

        passToNext(document);
    }
}