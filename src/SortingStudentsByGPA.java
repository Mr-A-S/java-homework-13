import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Сортировка по убыванию GPA
        return Double.compare(s2.getGpa(), s1.getGpa());
    }
}