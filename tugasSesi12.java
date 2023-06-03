import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;  

public class tugasSesi12 {
    public static void main(String[] args) {
        int[] array = generateRandomArray(10); // Menghasilkan array dengan 10 angka acak

        System.out.println("Array sebelum diurutkan:"); // Menampilkan array sebelum oprasi linear dan binary search
        printArray(array);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka target: ");
        int target = scanner.nextInt();

        // Mencoba linear search
        long startTime = System.nanoTime();
        int linearSearchIndex = linearSearch(array, target); // Mencari target
        long endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;

        // Mengurutkan array sebelum melakukan binary search
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        System.out.println("\nArray setelah diurutkan:");
        printArray(sortedArray);

        // Mencoba binary search
        startTime = System.nanoTime();// waktu awal
        int binarySearchIndex = binarySearch(sortedArray, target); // Mencari target
        endTime = System.nanoTime();// waktu akhir
        long binarySearchTime = endTime - startTime;

        System.out.println("\nHasil Linear Search:");
        System.out.println("Target berada pada Indeks ke: " + linearSearchIndex);
        System.out.println("Waktu yang dibutuhkan untuk mencari menggunakan linear search tanpa sorting adalah: " + linearSearchTime + " nanodetik");

        System.out.println("\nHasil Binary Search:");
        System.out.println("Target berada pada Indeks ke: " + binarySearchIndex);
        System.out.println("Waktu yang dibutuhkan untuk mencari menggunakan binary search dengan sorting adalah : " + binarySearchTime + " nanodetik");
    }

    // Fungsi untuk menghasilkan array tanpa angka yang sama dalam array
    private static int[] generateRandomArray(int size) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < size) {
            set.add((int) (Math.random() * 100)); // Menghasilkan angka random antara 0 hingga 99
        }
        int[] array = new int[size];
        int index = 0;
        for (Integer num : set) {
            array[index++] = num;
        }
        return array;
    }

    // Implementasi linear search
    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Mengembalikan indeks ketika target ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika target tidak ditemukan
    }

    // Implementasi binary search
    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target){
                return mid; // Mengembalikan indeks ketika target ditemukan
                } else if (array[mid] < target) {
                left = mid + 1;
                } else {
                right = mid - 1;
                }
                }    return -1; // Mengembalikan -1 jika target tidak ditemukan
            }

            // Fungsi untuk sorting dan mencetak array
            private static void printArray(int[] array) {
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            }
        }         