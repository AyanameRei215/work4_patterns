package work4.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.text.Collator;
import java.util.Locale;

public class StudentCollection {
    private List<Student> students;

    public StudentCollection() {
        this.students = new ArrayList<>();
        System.out.println("Створено нову колекцію студентів");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Додано студента: " + student.getName() + " з оцінкою " + student.getGrade());
    }

    public Iterator getSequentialIterator() {
        return new SequentialIterator();
    }

    public Iterator getAlphabeticalIterator() {
        return new AlphabeticalIterator();
    }

    public Iterator getGradeAscendingIterator() {
        return new GradeAscendingIterator();
    }

    public Iterator getGradeDescendingIterator() {
        return new GradeDescendingIterator();
    }

    private class SequentialIterator implements Iterator {
        private int currentPosition = 0;

        @Override
        public boolean hasNext() {
            return currentPosition < students.size();
        }

        @Override
        public Student next() {
            if (hasNext()) {
                Student student = students.get(currentPosition);
                currentPosition++;
                System.out.println("Послідовний ітератор: отримано студента на позиції " + (currentPosition - 1));
                return student;
            }
            return null;
        }

        @Override
        public void reset() {
            currentPosition = 0;
            System.out.println("Послідовний ітератор: скинуто до початку");
        }
    }

    private class AlphabeticalIterator implements Iterator {
        private List<Student> sortedStudents;
        private int currentPosition = 0;

        public AlphabeticalIterator() {
            sortedStudents = new ArrayList<>(students);

            Collator ukrainianCollator = Collator.getInstance(new Locale("uk", "UA"));
            Collections.sort(sortedStudents, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return ukrainianCollator.compare(s1.getName(), s2.getName());
                }
            });

            System.out.println("Алфавітний ітератор: відсортовано " + sortedStudents.size() + " студентів за українським алфавітом");
        }

        @Override
        public boolean hasNext() {
            return currentPosition < sortedStudents.size();
        }

        @Override
        public Student next() {
            if (hasNext()) {
                Student student = sortedStudents.get(currentPosition);
                currentPosition++;
                System.out.println("Алфавітний ітератор: отримано студента " + student.getName());
                return student;
            }
            return null;
        }

        @Override
        public void reset() {
            currentPosition = 0;
            System.out.println("Алфавітний ітератор: скинуто до початку");
        }
    }

    private class GradeAscendingIterator implements Iterator {
        private List<Student> sortedStudents;
        private int currentPosition = 0;

        public GradeAscendingIterator() {
            sortedStudents = new ArrayList<>(students);
            Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getGrade));
            System.out.println("Ітератор за зростанням оцінок: відсортовано " + sortedStudents.size() + " студентів");
        }

        @Override
        public boolean hasNext() {
            return currentPosition < sortedStudents.size();
        }

        @Override
        public Student next() {
            if (hasNext()) {
                Student student = sortedStudents.get(currentPosition);
                currentPosition++;
                System.out.println("Ітератор за зростанням: отримано студента з оцінкою " + student.getGrade());
                return student;
            }
            return null;
        }

        @Override
        public void reset() {
            currentPosition = 0;
            System.out.println("Ітератор за зростанням оцінок: скинуто до початку");
        }
    }

    private class GradeDescendingIterator implements Iterator {
        private List<Student> sortedStudents;
        private int currentPosition = 0;

        public GradeDescendingIterator() {
            sortedStudents = new ArrayList<>(students);
            Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getGrade).reversed());
            System.out.println("Ітератор за спаданням оцінок: відсортовано " + sortedStudents.size() + " студентів");
        }

        @Override
        public boolean hasNext() {
            return currentPosition < sortedStudents.size();
        }

        @Override
        public Student next() {
            if (hasNext()) {
                Student student = sortedStudents.get(currentPosition);
                currentPosition++;
                System.out.println("Ітератор за спаданням: отримано студента з оцінкою " + student.getGrade());
                return student;
            }
            return null;
        }

        @Override
        public void reset() {
            currentPosition = 0;
            System.out.println("Ітератор за спаданням оцінок: скинуто до початку");
        }
    }
}