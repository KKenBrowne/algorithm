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
	 * ��ʵ���ǲ�������ݴ����һ����ǰ�Ƚϣ�С�ڵĻ��Ͱ�pq[i]�����ƶ�һλ��ֱ������Ĵ���ĳ�������Ͳ����ȥ
	 * @param key
	 */
	public void insert(Key key) {
		//���һ��Ԫ������
        int i = n-1;
        //�����������С�ڣ������һ��Ԫ����ǰ������ʱ��
        while (i >= 0 && less(key, pq[i])) {
        //�����һ��Ԫ�������һλ
            pq[i+1] = pq[i];
            //i����һλ
            i--;
        }
        //��ֵkey��n����
        pq[i+1] = key;
        n++;
    }
    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }
	
	

}
