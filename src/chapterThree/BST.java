package chapterThree;

import javax.print.attribute.standard.RequestingUserName;
import javax.security.auth.kerberos.KeyTab;

import com.sun.javafx.sg.prism.NodePath;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import edu.princeton.cs.algs4.Queue;
import sun.net.www.content.text.plain;

public class BST <Key extends Comparable<Key>,Value>{
	//���������Ҹ��ڵ�
	private Node root;      
	
	private class Node{
		
		private Key key;    //��
		private Value val;	//ֵ
		private Node left,right; //ָ������������
		private int N;  //�Ѹýڵ�Ϊ�����ӽڵ�����
		
		public Node(Key key,Value val,int N)
		{
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(Node x)
	{
		if(x==null) return 0;
		else {return x.N;}
	}
	
	//�����Ż���get
	public Value get(Key key)
	{
		Node x = root;
		while(x!=null)
		{
			int cmp = key.compareTo(x.key);
			if(cmp==0) return x.val;
			else if(cmp<0) x = x.left;
			else if(cmp>0) x = x.right;
		}
		return null;
	}
	
//	private Value get(Node x,Key key)
//	{
//		//�ڵ㲻���ڣ�����null
//		if(x==null) return null;
//		int cmp = key.compareTo(x.key);
//		//������ҵıȴ˽ڵ��С���ͼ�����ڵ���ң���֮�ҽڵ�
//		if(cmp<0) return get(x.left, key);
//		else if(cmp>0) return get(x.right, key);
//		else return x.val;
//	}
//	
//	
//	public Value get(Key key){
//		return get(root,key);
//	}
	
	private Node put(Node x,Key key,Value val){
		//���x�ڵ㲻���ڣ����½�һ��X�ӽڵ�
		if(x==null) return new Node(key,val,1);
		//���x�ڵ���ڣ�key�����ڣ��Ƚϣ�С����ţ������ҷţ��������У������ʵ�λ�ã��ݹ�����ø��ڵ�ָ���ӽڵ�����ӣ������Ӽ�������ֵ
		int cmp = key.compareTo(x.key);
		if(cmp<0)      x.left  =  put(x.left,key,val);
		else if(cmp>0) x.right =  put(x.right,key,val);
		// =0����key���ڣ�ֱ�Ӹ���
		else x.val = val;
		//·����ÿ���ڵ�ļ�������1�����������ӽڵ��һ
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void put(Key key,Value val){
		root = put(root, key, val);
	}
	
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x)
	{
		//�ݹ�
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Key max()
	{
		return max(root).key;
	}
	
	private Node max(Node x){
		if(x.right==null) return x;
		return max(x.right);
	}
	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if(x==null) return null;
		return x.key;
	}
	
	private Node floor(Node x,Key key)
	{
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp<0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t !=null) return x;
		else return x;
	}
	
	public Key select(int k){
		return select(root,k).key;
	}
	
	//��������Ϊk�ļ�
	private Node select(Node x,int k)
	{
		if(x==null) return null;
		//�����еĽڵ���
		int t = size(x.left);
		//��������еĽڵ�������k�������ݹ���������в���
		if(t>k) return select(x.left, k);
		//�����еĽڵ���С��k��������������Ϊk-t-1
		else if(t<k) return select(x.right, k-t-1);
		//�ڵ�������k�ģ�����
		else return x;
	}
	
	//rank��̫��
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key,Node x)
	{
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return rank(key, x.left);
		else if(cmp>0) return 1+size(x.left)+rank(key, x.right);
		else return size(x.left);
	}
	
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	
	//���ϼ���������ֱ���ҵ��յ������ӣ����ظýڵ�������ӣ��ݹ���ú�������Ӻͽڵ������
	private Node deleteMin(Node x)
	{
		if(x.left==null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) +1;
		return x;
	}
	
	public void deleteMax()
	{
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node x)
	{
		if(x.right==null) return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) +1;
		return x;
	}
	
	
	public void delete(Key key)
	{
		//�µĸ��ڵ�Ϊɾ��֮��ĸ��ڵ�
		root = delete(root, key);
	}
	
	private Node delete(Node x,Key key)
	{
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0)      x.left = delete(x.left,key);
		else if(cmp>0) x.right  = delete(x.right, key);
		//�ҵ��˸�ɾ���Ľڵ��
		else
		{
			//����Ǹ��ڵ�Ļ�
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			//��ָ�򼴽���ɾ���Ľڵ㱣��ָ��Ϊt
			Node t = x;
			//��X��ֵΪ���ұ�������С���Ǹ�����ʱx�������ǿյ�
			x = min(t.right);
			//��������ָ��ɾ����С��֮����Ȼ���нڵ㶼����x.key�Ķ�����
			x.right = deleteMin(t.right);
			//��X���������Ϊԭ�������
			x.left = t.left;
		}
		//���´�С
		x.N = size(x.left) + size(x.right) +1;
		return x;
	}
	public Iterable<Key> keys()
	{ return keys(min(),max());}
	
	
	public Iterable<Key> keys(Key lo,Key hi)
	{ 
		Queue<Key> queue = new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue;
	
	}
	
	
	private void keys(Node x,Queue<Key> queue,Key lo,Key hi)
	{
		if(x==null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo<0) keys(x.left, queue, lo, hi);
		if(cmplo<=0 && cmphi>=0) queue.enqueue(x.key);
		if(cmphi>0) keys(x.right, queue, lo, hi);
		
	}
	
	  public int height() 
	  {
        return height(root);
	  }
	  private int height(Node x) 
	  {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
      }	

	
	

}
