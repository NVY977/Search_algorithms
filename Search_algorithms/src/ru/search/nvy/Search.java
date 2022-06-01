package ru.search.nvy;

public class Search {
    public static int recursiveBinarySearch(int[] arr, int firstElement, int lastElement, int elementToSearch) {
        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch)
                return mid;

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (arr[mid] > elementToSearch)
                return recursiveBinarySearch(arr, firstElement, mid - 1, elementToSearch);

            // также, вызываем метод рекурсивно по суженным данным
            return recursiveBinarySearch(arr, mid + 1, lastElement, elementToSearch);
        }
        return 0;
    }

    public static int jumpSearch(int[] integers, int elementToSearch) {

        int arrayLength = integers.length;
        int jumpStep = (int) Math.sqrt(integers.length);
        int previousStep = 0;

        while (integers[Math.min(jumpStep, arrayLength) - 1] < elementToSearch) {
            previousStep = jumpStep;
            jumpStep += (int)(Math.sqrt(arrayLength));
            if (previousStep >= arrayLength)
                return -1;
        }
        while (integers[previousStep] < elementToSearch) {
            previousStep++;
            if (previousStep == Math.min(jumpStep, arrayLength))
                return -1;
        }

        if (integers[previousStep] == elementToSearch)
            return previousStep;
        return 0;
    }
    public static void main(String[] args) {
        int index = recursiveBinarySearch(new int[]{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 0, 10, 67);
        int index1 = jumpSearch(new int[]{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 67);
        System.out.println("binarySearch: " + index + " jumpSearch: " + index1);

    }
}
