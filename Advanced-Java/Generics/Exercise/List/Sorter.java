package Generics.Exercise.List;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {

        for (int i = 0; i < customList.size() - 1; i++) {
            for (int j = 0; j < customList.size() - i - 1; j++) {
                if (customList.get(j).compareTo(customList.get(j + 1)) > 0) {
                    customList.swap(j, j + 1);
                }
            }
        }
    }
}
