package StackQueue;
import com.sun.prism.image.CompoundTexture;

public class UF {
	private int[] id; //分量id
	private int count; //分量数量

	public UF(int N)
	{
		count = N;
		id = new int [N];
		for(int i=0;i<N;i++)
		{
			id[i] = i;
		}
	}
	public int count(){
		return count;
	}
	public boolean connected(int p,int q){
		return fFind(p)==fFind(q);
	}
	/**
	 * quick-find
	 * @param p
	 * @return
	 */
	public int fFind(int p)
	{
		return id[p];
	}
	
	public void fUnion(int p,int q)
	{
		int pID = fFind(p);
		int qID = fFind(q);
		if(pID==qID){return;}
		for(int i=0;i<id.length;i++)
		{
			if(id[i]==pID){
				id[i]=qID;
			}
		}		
		count--;
	}
	
	/**
	 * quick-union
	 * @param p
	 * @return
	 */
	private int uFind(int p){
		while(p!=id[p]){
			p=id[p];
		}
		return p;
	}
	public void uUnion(int p,int q){
		int pRoot = uFind(p);
		int qRoot = uFind(q);
		if(pRoot==qRoot){return;}
		id[pRoot]=qRoot;
		count--;
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
