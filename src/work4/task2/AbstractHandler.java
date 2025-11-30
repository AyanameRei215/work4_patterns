package work4.task2;

public abstract class AbstractHandler implements Handler {
    protected Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        System.out.println(this.getClass().getSimpleName() + " -> " + nextHandler.getClass().getSimpleName());
    }

    protected void passToNext(Document document) {
        if (nextHandler != null) {
            nextHandler.handle(document);
        } else {
            System.out.println("✅ УСІ ПЕРЕВІРКИ ПРОЙДЕНО УСПІШНО! Документ '" + document.getName() + "' прийнято.");
        }
    }
}