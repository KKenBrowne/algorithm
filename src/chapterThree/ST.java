package chapterThree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//性能并不高，用MAP实现  符号表  API
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    /**
     * 构造函数.
     */
    public ST() {
        st = new TreeMap<Key, Value>();
    }


    /**
     * 返回key对应的value.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in this symbol table;
     *         {@code null} if the key is not in this symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("called get() with null key");
        return st.get(key);
    }

    /**
     *插入键值对，key为空抛出异常，val为空删除key
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("called put() with null key");
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    /**
    	删除key和对应的value
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("called delete() with null key");
        st.remove(key);
    }

    /**
     * 如果key存在于st  Map里，返回true
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with null key");
        return st.containsKey(key);
    }

    /**
     * 返回treeMap的大小
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return st.size();
    }

    /**
     * 是否为空.
     *
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 返回所有的key.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /**
     * Returns all of the keys in this symbol table.
     * To iterate over all of the keys in a symbol table named {@code st}, use the
     * foreach notation: {@code for (Key key : st)}.
     * <p>
     * This method is provided for backward compatibility with the version from
     * <em>Introduction to Programming in Java: An Interdisciplinary Approach.</em>
     *
     * @return     an iterator to all of the keys in this symbol table
     * @deprecated Replaced by {@link #keys()}.
     */
    @Deprecated
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /**
     * 返回tree里最小的key.
     *
     * @return the smallest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return st.firstKey();
    }

    /**
     * 返回tree里最大的key
     *
     * @return the largest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return st.lastKey();
    }

    /**
     * 向上取整.
     *
     * @param  key the key
     * @return the smallest key in this symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("called ceiling() with null key");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /**
     * 向下取整.
     *
     * @param  key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("called floor() with null key");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /**
     * Unit tests the {@code ST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}