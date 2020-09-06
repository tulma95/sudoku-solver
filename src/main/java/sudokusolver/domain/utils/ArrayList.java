package sudokusolver.domain.utils;

import java.lang.reflect.Array;

public class ArrayList<T> {
    private T[] array;
    private int size;

    public ArrayList() {
        this.array = (T[]) new Object[10];
        size = 0;
    }

    public T get(int index) {
        return array[index];
    }

    public int getSize() {
        return size;
    }

    public void add(T newObject) {
        if (this.size == this.array.length) {
            increaseMaxSize();
        }
        this.array[size] = newObject;
        size++;

    }

    private void increaseMaxSize() {
        T[] newArray = (T[]) new Object[this.array.length * 3 / 2 + 1];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }
}
