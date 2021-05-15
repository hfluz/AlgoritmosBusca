package br.pucpr.ed.map;

import br.pucpr.ed.list.List;
import br.pucpr.ed.list.UnorderedArrayList;

public class UnorderedMap<K extends Comparable, V> implements Map<K, V> {

    private UnorderedArrayList<Entry<K, V>> entries;

    public UnorderedMap(int capacity) {
        entries = new UnorderedArrayList<>(capacity);
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    private Entry<K, V> find(K key) {
        return entries.find(new Entry<>(key));
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = find(key);
        return entry != null ? entry.value : null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public List<K> keySet() {
        List<K> keys = new UnorderedArrayList<>(entries.size());
        for (int i = 0; i < entries.size(); i++) {
            Entry<K, V> entry = entries.get(i);
            keys.add(entry.key);
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> values = new UnorderedArrayList<V>(entries.size());
        for (int i = 0; i < entries.size(); i++) {
            Entry<K, V> entry = entries.get(i);
            values.add(entry.value);
        }
        return values;
    }

    @Override
    public List<Entry<K, V>> entrySet() {
        return entries;
    }
}
