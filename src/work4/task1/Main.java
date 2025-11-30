package work4.task1;

public class Main {

    public static void main(String[] args) {
        StudentCollection collection = new StudentCollection();

        System.out.println("=== Створення студентів ===");
        collection.addStudent(new Student("Іван", 85.5));
        collection.addStudent(new Student("Петро", 92.0));
        collection.addStudent(new Student("Марія", 76.5));
        collection.addStudent(new Student("Оксана", 88.0));
        collection.addStudent(new Student("Андрій", 79.5));
        collection.addStudent(new Student("Наталія", 95.0));
        collection.addStudent(new Student("Євген", 82.0));
        collection.addStudent(new Student("Ярослав", 89.5));
        collection.addStudent(new Student("Юлія", 91.0));

        System.out.println("\n=== Звичайний послідовний обхід ===");
        printStudents(collection.getSequentialIterator());

        System.out.println("\n=== Обхід за алфавітом (український) ===");
        printStudents(collection.getAlphabeticalIterator());

        System.out.println("\n=== Обхід за зростанням оцінок ===");
        printStudents(collection.getGradeAscendingIterator());

        System.out.println("\n=== Обхід за спаданням оцінок ===");
        printStudents(collection.getGradeDescendingIterator());
    }

    private static void printStudents(Iterator iterator) {
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("  " + student);
        }
    }
}