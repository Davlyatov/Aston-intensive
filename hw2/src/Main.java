import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        addTest();
        addAllTest();
        clearTest();
        getTest();
        isEmptyTest();
        removeTest();
        sortTest();
    }

    private static void sortTest() {
        System.out.println("============SortTest=============");
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        Integer[] ints = {1,678,23,15,897,123,87,543,980,423,2,6,3,5,7,9,10};
        customArrayList.addAll(List.of(ints));
        System.out.println("CustomArrayList before sorting: " + customArrayList);
        customArrayList.sort(Comparator.naturalOrder());
        System.out.println("CustomArrayList after sorting: " + customArrayList);
        System.out.println("=================================");
    }

    private static void removeTest() {
        System.out.println("=============RemoveTest===========");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] strings = {"Хахаха", "das","dds","dsa","dsd"};
        customArrayList.addAll(List.of(strings));
        System.out.println("CustomArrayList: " + customArrayList);
        System.out.println("CustomArrayList size: " + customArrayList.getSize());
        customArrayList.remove(0);
        customArrayList.remove("dds");
        System.out.println("CustomArrayList: " + customArrayList);
        System.out.println("CustomArrayList size: " + customArrayList.getSize());
        System.out.println("=================================");
    }

    private static void isEmptyTest() {
        System.out.println("===========IsEmptyTest============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] strings = {"Хахаха", "das","dds","dsa","dsd"};
        customArrayList.addAll(List.of(strings));
        System.out.println("CustomArrayList: " + customArrayList);
        System.out.println("Is array list is empty: "+customArrayList.isEmpty());
        System.out.println("=================================");
    }

    private static void getTest() {
        System.out.println("=============GetTest=============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] strings = {"Хахаха", "das","dds","dsa","dsd"};
        customArrayList.addAll(List.of(strings));
        System.out.println(customArrayList.get(0));
        System.out.println("=================================");
    }

    private static void clearTest() {
        System.out.println("============ClearTest============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] strings = {"Хахаха", "das","dds","dsa","dsd"};
        customArrayList.addAll(List.of(strings));
        System.out.println("CustomArrayList size after adding: " + customArrayList.getSize());
        customArrayList.clear();
        System.out.println("CustomArrayList size after clear: " + customArrayList.getSize());
        System.out.println("=================================");
    }

    private static void addAllTest() {
        System.out.println("=============AddAllTest==========");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String[] strings = {"Хахаха", "das","dds","dsa","dsd"};
        customArrayList.addAll(List.of(strings));
        System.out.println("CustomArrayList: " + customArrayList);
        System.out.println("CustomArrayList size: " + customArrayList.getSize());
        System.out.println("=================================");
    }

    private static void addTest() {
        System.out.println("=============AddTest=============");
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add(0, "Xaxaxa");
        System.out.println("CustomArrayList: " + customArrayList);
        System.out.println("CustomArrayList size: " + customArrayList.getSize());
        System.out.println("=================================");
    }
}