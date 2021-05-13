package br.pucpr.ed.list;

import java.util.StringJoiner;

public class OrderedArrayList<T extends Comparable> implements List<T> {
    private T[] array;
    private Integer size;

    public OrderedArrayList(Integer capacity) {
        this.size = 0;
        array = (T[]) new Comparable[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        if(size == array.length){
            throw new IndexOutOfBoundsException();
        }
        int j = size;
        size++;
        while (j > 0 && array[j - 1].compareTo(element) > 0) {
            array[j] = array[j - 1];
            j--;
        }
        array[j] = element;
    }

    @Override
    public T remove(T element) {
        for(int i = 0; i < array.length - 1; i++){
            if(array[i].equals(element)){
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public T remove(int index) {
        T registroExcluido = array[index];
        // Começamos a deslocar os registros com pontuação inferior 1 posição para cima
        for(int i = index; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }
        // Setamos o último registro (que já foi movido para cima) para null, liberando memória.
        size--;
        array[size] = null;
        return registroExcluido;
    }

    @Override
    public T find(T key) {
        return null;
    }

    @Override
    public boolean exists(T key) {
        return false;
    }

    @Override
    public T get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if(size == 0) return null;
        StringJoiner joiner = new StringJoiner(", ");
        for(int i = 0; i < size; i++){
            joiner.add(array[i].toString());
        }
        return "{" + joiner.toString() + "}";
    }
}
