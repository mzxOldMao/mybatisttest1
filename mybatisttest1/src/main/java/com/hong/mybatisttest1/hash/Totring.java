package com.hong.mybatisttest1.hash;

public class Totring<K,V> {
    private Entry<K,V>[] table;
    private static final Integer CAPACITY = 8;
    private int size;
    class Entry<K,V>{
        public K key;
        public V value;
        public Entry<K, V> next;
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }
    public V put(K k,V v) {
        if (table == null) {
            inflater();
        }
        int hashCode = hash(k);
        int index = indexFor(hashCode);
        for(Entry<K, V> entry=table[index];entry!=null;entry=entry.next) {
            if (entry.key.equals(k)) {
                entry.value=v;
                return entry.value;
            }
        }
        addEntry(k,v,index);
        return null;
    }
    public V get(K k) {
        int hashCode = hash(k);
        int index = indexFor(hashCode);
        for(Entry<K, V> entry=table[index];entry!=null;entry=entry.next) {
            if (entry.key.equals(k)) {
                return entry.value;
            }
        }
        return null;
    }
    public void remove(K k) throws Exception {
        int hashCode = hash(k);
        int index = indexFor(hashCode);
        if (table[index]==null) {
            throw new Exception("待删除节点不存在@@@");
        }else {
            if (table[index].key.equals(k)) {
                table[index]=table[index].next;
                size--;
                return;
            }
        }
        //Entry<K, V> first = table[index];
        for(Entry<K, V> entry=table[index];entry!=null;entry=entry.next) {
            if (entry.next == null) {
                throw new Exception("待删除节点不存在@@@");
            }
            if (entry.next.key.equals(k)) {//d  c  b  a
                entry.next = entry.next.next;
                size--;
                return;
            }

        }
        return;
    }
    private void addEntry(K k, V v, int index) {
        table[index]=new Entry<K,V>(k, v,table[index]);
        size++;
    }
    private int indexFor(int hashCode) {
        return (table.length-1)&hashCode;
    }
    private int hash(K k) {
        int h;
        return (h=k.hashCode())^(h>>>16);
    }
    private void inflater() {
        table = new Entry[CAPACITY];
    }
    public static void main(String[] args) throws Exception {
        Totring<String, Object> totring = new Totring<String, Object>();
        totring.put("a", 1);
        totring.put("b", 2);
        totring.put("c", 3);
        totring.put("b", 4);
        totring.put("a", 5);
        totring.put("d", 6);
        totring.put("e", 64);
        totring.put("f", 63);
        totring.put("g", 62);
        totring.put("hl", 61);
        totring.put("ghh", 62);
        totring.put("gg", 62);
        totring.put("gyh", 62);
        totring.put("gj", 62);
        totring.put("ssg", 62);

        /*System.out.println(totring.get("a"));
        System.out.println(totring.get("b"));
        System.out.println(totring.get("c"));
        System.out.println(totring.get("d"));*/
        System.out.println(totring.size);
        System.out.println("----------------");
        totring.remove("d");
        System.out.println(totring.size);
        System.out.println(totring.get("a"));/*
        System.out.println(totring.get("b"));
        System.out.println(totring.get("c"));
        System.out.println(totring.get("d"));*/
    }
}
