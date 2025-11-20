public class Student implements Comparable<Student> {
    private int idNumber;
    private double gpa; // Средний балл

    public Student(int idNumber, double gpa) {
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + idNumber +
                ", gpa=" + gpa +
                '}';
    }

    // Реализация Comparable для сортировки по ID (Задание 1 и 4)
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.idNumber, o.idNumber);
    }
}