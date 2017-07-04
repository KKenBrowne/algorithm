package Sort;


/**
 * 自底向上merge排序
 * @author Administrator
 *
 */
public class MergeBU {
	private static Comparable []aux;
	
	public static void sort(Comparable[]a){
		int N = a.length;
		aux = new Comparable[N];
		//sz是子数组大小
		for(int sz=1;sz<N;sz+=sz){
			for(int lo=0;lo<N-sz;lo+=sz+sz)
				Merge.merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
		}
	}
	

}
