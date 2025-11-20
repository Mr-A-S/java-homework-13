import java.util.Comparator;

public class LabClassUI {
    public static void main(String[] args) {
        // --- ЗАДАНИЕ 1 и 2 (то, что уже было) ---
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

        SortingStudentsByGPA comparator = new SortingStudentsByGPA();
        quickSort(students, 0, students.length - 1, comparator);
        System.out.println("\n--- Задание 2: QuickSort по GPA (убывание) ---");
        printArray(students);

        // --- ЗАДАНИЕ 3: Сортировка слиянием (Merge Sort) ---
        System.out.println("\n--- Задание 3: Сортировка слиянием двух списков ---");
        Student[] list1 = { new Student(10, 4.5), new Student(3, 3.2) };
        Student[] list2 = { new Student(22, 2.9), new Student(1, 3.8) };

        // Объединяем и сортируем
        Student[] merged = mergeSort(list1, list2);
        printArray(merged);
    }

    public static void printArray(Student[] arr) {
        for (Student s : arr) {
            System.out.println(s);
        }
    }

    // --- Методы для Задания 1 (Вставки) ---
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

    // --- Методы для Задания 2 (QuickSort) ---
    public static void quickSort(Student[] array, int low, int high, Comparator<Student> cmp) {
        if (array.length == 0) return;
        if (low >= high) return;

        int middle = low + (high - low) / 2;
        Student pivot = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (cmp.compare(array[i], pivot) < 0) i++;
            while (cmp.compare(array[j], pivot) > 0) j--;
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

    // --- Методы для Задания 3 (Merge Sort) ---

    // 1. Главный метод: создает общий массив и запускает сортировку
    public static Student[] mergeSort(Student[] a1, Student[] a2) {
        Student[] result = new Student[a1.length + a2.length];
        System.arraycopy(a1, 0, result, 0, a1.length);
        System.arraycopy(a2, 0, result, a1.length, a2.length);

        mergeSortRecursive(result, result.length);
        return result;
    }

    // 2. Рекурсивное разбиение
    private static void mergeSortRecursive(Student[] a, int n) {
        if (n < 2) return;
        int mid = n / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);

        mergeSortRecursive(l, mid);
        mergeSortRecursive(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    // 3. Слияние двух частей
    private static void merge(Student[] a, Student[] l, Student[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            // Сортируем по ID (используем compareTo)
            if (l[i].compareTo(r[j]) <= 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) a[k++] = l[i++];
        while (j < right) a[k++] = r[j++];
    }
}