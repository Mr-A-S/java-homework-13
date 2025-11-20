public class LabClassUI {
    public static void main(String[] args) {
        Student[] students = {
                new Student(15, 3.5),
                new Student(2, 4.0),
                new Student(40, 2.8),
                new Student(4, 3.9)
        };

        System.out.println("До сортировки:");
        printArray(students);

        insertionSort(students);

        System.out.println("\nПосле сортировки вставками (по ID):");
        printArray(students);
    }

    // Алгоритм сортировки вставками
    public static void insertionSort(Student[] arr) {
        for (int left = 1; left < arr.length; left++) {
            Student value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                // Используем compareTo (сортировка по ID)
                if (value.compareTo(arr[i]) < 0) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
    }

    public static void printArray(Student[] arr) {
        for (Student s : arr) {
            System.out.println(s);
        }
    }
}