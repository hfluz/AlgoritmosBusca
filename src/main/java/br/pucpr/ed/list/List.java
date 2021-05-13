package br.pucpr.ed.list;

public interface List<T> {
    int size();
    void add(T element);
    T remove(T element);
    T remove(int index);
    T find(T key);
    boolean exists(T key);
    T get(int index);
    boolean isEmpty();
}
