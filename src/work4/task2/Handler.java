package work4.task2;

public interface Handler {

    void handle(Document document);

    void setNextHandler(Handler nextHandler);
}