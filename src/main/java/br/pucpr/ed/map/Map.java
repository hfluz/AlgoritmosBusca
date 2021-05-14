package br.pucpr.ed.map;

import br.pucpr.ed.list.List;

public interface Map<K extends Comparable,V> {
    int size();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    List<K> keySet();
    List<V> values();
    List<Entry<K,V>> entrySet();
}
