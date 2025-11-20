import java.util.Comparator;

public class LabClassUI {
    public static void main(String[] args) {
        // Создаем массив студентов
        Student[] students = {
                new Student(15, 3.5),
                new Student(2, 4.0),
                new Student(40, 2.8),
                new Student(4, 3.9)
        };

        System.out.println("До сортировки:");
        printArray(students);

        // --- ЗАДАНИЕ 1: Сортировка вставками (по ID) ---
        insertionSort(students);
        System.out.println("\nПосле сортировки вставками (по ID):");
        printArray(students);

        // --- ЗАДАНИЕ 2: QuickSort (по GPA убывание) ---
        // Создаем компаратор
        SortingStudentsByGPA comparator = new SortingStudentsByGPA();
        // Запускаем быструю сортировку
        quickSort(students, 0, students.length - 1, comparator);

        System.out.println("\n--- Задание 2: QuickSort по GPA (убывание) ---");
        printArray(students);
    }

    // Метод для вывода массива
    public static void printArray(Student[] arr) {
        for (Student s : arr) {
            System.out.println(s);
        }
    }

    // Сортировка вставками (из Задания 1)
    public static void insertionSort(Student[] arr) {
        for (int left = 1; left < arr.length; left++) {
            Student value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.compareTo(arr[i]) < 0) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
    }

    // Быстрая сортировка (QuickSort) из Задания 2
    public static void quickSort(Student[] array, int low, int high, Comparator<Student> cmp) {
        if (array.length == 0) return;
        if (low >= high) return;

        int middle = low + (high - low) / 2;
        Student pivot = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (cmp.compare(array[i], pivot) < 0) {
                i++;
            }
            while (cmp.compare(array[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(array, low, j, cmp);
        if (high > i) quickSort(array, i, high, cmp);
    }
}