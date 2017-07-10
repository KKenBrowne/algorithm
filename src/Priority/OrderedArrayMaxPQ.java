package Priority;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key [] pq;
	private int n;
	
	public OrderedArrayMaxPQ(int capacity){
		pq = (Key[]) new Comparable[capacity];
		n = 0;
	}
	
	public boolean isEmpty(){ return n==0;}
	
	public int size(){return n;}
	
	public Key delMax() { return pq[--n];}
	
	
	/**
	 * 其实就是插入的数据从最后一个往前比较，小于的话就把pq[i]往后移动一位，直到插入的大于某个数，就插入进去
	 * @param key
	 */
	public void insert(Key key) {
		//最后一个元素坐标
        int i = n-1;
        //当插入的数据小于（从最后一个元素往前数）的时候
        while (i >= 0 && less(key, pq[i])) {
        //把最后一个元素向后移一位
            pq[i+1] = pq[i];
            //i减少一位
            i--;
        }
        //赋值key，n增加
        pq[i+1] = key;
        n++;
    }
    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }
	
	

}
