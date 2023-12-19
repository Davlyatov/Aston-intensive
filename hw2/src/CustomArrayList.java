import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E> {
    private int size;
    Object[] elementData;

    public CustomArrayList() {
        elementData = new Object[]{};
    }

    public CustomArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            increaseCapacity();
        }
        elementData[index] = element;
        size++;
    }

    public void add(E element) {
        increaseCapacity();
        elementData[size] = element;
        size++;
    }

    public void addAll(Collection<? extends E> c) {
        Object[] addedArray = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            add((E) addedArray[i]);
        }
    }

    public void clear() {
        elementData = new Object[]{};
        size = 0;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            elementData[0] = "";
        }
        decreaseCapacity(index);
    }

    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                decreaseCapacity(i);
                break;
            }
        }
    }

    public void sort(Comparator<? super E> c) {
        quickSort(0, size - 1, c);
    }

    private void quickSort(int from, int to, Comparator<? super E> c) {
        if (from < to) {
            int divideIndex = partition(from, to, c);

            quickSort(from, divideIndex - 1, c);
            quickSort(divideIndex, to, c);
        }
    }

    private int partition(int from, int to, Comparator<? super E> c) {
        int rightIndex = to;
        int leftIndex = from;

        E pivot = (E) elementData[from];

        while (leftIndex <= rightIndex) {

            E element1 = (E) elementData[leftIndex];
            E element2 = (E) elementData[rightIndex];

            while (c.compare(element1, pivot) < 0) {
                leftIndex++;
                element1 = (E) elementData[leftIndex];
            }

            while (c.compare(element2, pivot) > 0) {
                rightIndex--;
                element2 = (E) elementData[rightIndex];
            }

            if (leftIndex <= rightIndex) {
                swap(rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private void swap(int rightIndex, int leftIndex) {
        E temp = (E) elementData[rightIndex];
        elementData[rightIndex] = elementData[leftIndex];
        elementData[leftIndex] = temp;
    }


    private void increaseCapacity() {
        if (size == elementData.length)
            elementData = Arrays.copyOf(elementData, elementData.length + 1);
    }

    private void decreaseCapacity(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData = Arrays.copyOf(elementData, elementData.length - 1);
        size--;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return Arrays.toString(elementData);
    }
}
