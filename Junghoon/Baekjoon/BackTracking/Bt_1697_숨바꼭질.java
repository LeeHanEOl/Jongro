package bt;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

class Soom{
	static final int max=100000;
	boolean position[]=new boolean[100001];
	int min=99999999;
		
	class Node {				//ť�� ���� ���� ��ġ����
		int num;
		int depth;
		Node(int num,int depth) {
			this.num=num;
			this.depth=depth;
		}
	}
	
	public void dfs(int n,int k,int result) {
		
		if(min<=result) {
			return;
		}
		if(n==k) {
			min=result;
			return;
		}
		
		position[n]=true;		
		if(n<k && position[n+1]!=true) {		//��������� dfs
			dfs(n+1,k,result+1);
		}
		if(n<k && position[n-1]!=true) {
			dfs(n-1,k,result+1);
		}
		if(n<k && 2*n<max && position[2*n]!=true) {
			dfs(2*n,k,result+1);
		}
		position[n]=false;		//back tracking;
	}


	
	public void bfs(int n,int k) {
		Queue<Node> q=new LinkedList<Node>();		//ù��° depth ť �����鼭 ����
		q.add(new Node(n,0));
		
		while(!q.isEmpty()) {
			Node temp=q.poll();						// dequeue
			if(temp.depth>=min || position[temp.num]==true) {	// �ּ��� ������ �ƴϸ�
				continue;
			}
			if(temp.num == k) {									//���� ã������
				min=temp.depth;
				return ;
			}

			position[temp.num]=true;							//���� �ε��� ��ģ�� ǥ��
			
			if(temp.num<k && position[temp.num+1]!=true) {		//enqueue�ϸ鼭 �ʺ�켱 Ž��
				q.add(new Node(temp.num+1,temp.depth+1));
			}
			if(temp.num>0 && position[temp.num-1]!=true) {
				q.add(new Node(temp.num-1,temp.depth+1));
			}
			if(temp.num<k && 2*temp.num<=max && position[temp.num*2]!=true) {
			    q.add(new Node(temp.num*2,temp.depth+1));
			}
			
		}
		
	}	
}

public class Bt_1697_���ٲ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Soom soom=new Soom();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		soom.bfs(n, k);
		System.out.println(soom.min);
	}
}