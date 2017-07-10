package Priority;


public class MaxPQ <Key extends Comparable<Key>>{
	
	private Key [] pq;   //基于堆的全程二叉树
	private int N = 0;  //存储于pq[1至N]中,pq[0]不使用
	
	private boolean less(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	
	private  void exch(int i,int j){
		Key t = pq[i];
		pq[i]=pq[j];
		pq[j] = t;
	}
	//构造函数，创建一个长度为maxN的pq数组
	public MaxPQ(int maxN){
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty(){ return N==0;}
	
	public int size(){ return N;}
	
	public void insert(Key v){
		//新增一个数在数组末尾，N增加
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax(){
		Key max = pq[1];  //从根节点获取最大元素
		exch(1, N--);     //和最后一个节点交换,N减少1
		pq[N+1]=null;     //删除最后并防止对象游离
		sink(1);          //恢复有序性
		return max;
	}
	
	
	
	private  void swim(int k)
	{
		while(k>1 && less(k/2,k))
		{
			exch(k/2, k);
			k=k/2;
		}
	}
	
	private  void sink(int k)
	{
		//当存在子节点的时候执行
		while(2*k<=N)
		{
			int j =2*k;
			if(j<N && less(j,j+1)) j++; 
			if(!less(k,j)) break;  //与两个儿子比较，选择较小的比较
			exch(k, j);
			k=j;
		}
		
	}
	
	

}
