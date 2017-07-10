package Priority;


public class MaxPQ <Key extends Comparable<Key>>{
	
	private Key [] pq;   //���ڶѵ�ȫ�̶�����
	private int N = 0;  //�洢��pq[1��N]��,pq[0]��ʹ��
	
	private boolean less(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	
	private  void exch(int i,int j){
		Key t = pq[i];
		pq[i]=pq[j];
		pq[j] = t;
	}
	//���캯��������һ������ΪmaxN��pq����
	public MaxPQ(int maxN){
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty(){ return N==0;}
	
	public int size(){ return N;}
	
	public void insert(Key v){
		//����һ����������ĩβ��N����
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax(){
		Key max = pq[1];  //�Ӹ��ڵ��ȡ���Ԫ��
		exch(1, N--);     //�����һ���ڵ㽻��,N����1
		pq[N+1]=null;     //ɾ����󲢷�ֹ��������
		sink(1);          //�ָ�������
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
		//�������ӽڵ��ʱ��ִ��
		while(2*k<=N)
		{
			int j =2*k;
			if(j<N && less(j,j+1)) j++; 
			if(!less(k,j)) break;  //���������ӱȽϣ�ѡ���С�ıȽ�
			exch(k, j);
			k=j;
		}
		
	}
	
	

}
