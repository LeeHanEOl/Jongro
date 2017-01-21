/**
 * �÷��̵�-���� �˰���(Floyd-Warshall Algorithm)�� �׷������� ��� ������ ������ �ִ� ����� �Ÿ���
 * ���ϴ� �˰����̴�. ���� ����ġ�� ���� ������ ��ȯ�� ���ٸ� �� ó���ȴ�. ���� �ٱ��� �ݺ����� ���İ��� ������
 * �̰�, �� ��° �ݺ����� ����ϴ� ������, �� ��° �ݺ����� �����ϴ� �������̴�. �� �˰����� �÷��̵� �˰���
 * �̶�� �˷��� �ִ�.
 * 
 * �÷��̵�-���� �˰����� ���� ��ȹ�� ��������, �׷��� ���� ��� �� ������ �մ� ����� �ּ� ����� ���Ѵ�. 
 * ���⿡ �������� ����ϸ� �ּ� ��� ��α��� ���� �� �ִ�. �÷��̵�-���� �˰����� ������ ���� �������� ����Ǿ���.
 *   -�� ������ �մ� �ּ� ��� ��δ� �������� ��ġ�ų� ��ġ�� �ʴ� ��� �� �ϳ��� ���Ѵ�.
 *   -���� �������� ��ģ�ٸ� �װ��� �̷�� �κ� ��� ���� �ּ� ��� ��ο��� �Ѵ�.
 * 
 */

import java.util.Scanner;

class AdjMatrix {
	public int matrix[][]; //�������� �����ִ� �ּҰ� ����

	public AdjMatrix(int cNum) {
		matrix=new int[cNum+1][cNum+1];
		for(int i=1;i<cNum+1;i++) {
			for(int j=1;j<cNum+1;j++) {
				matrix[i][j]=(i==j ? 0:100001);
			}
		}
	}
	
	

	public void insertEdge(int v1,int v2,int cost) {
		if(matrix[v1][v2]!=0) {
			if(cost<matrix[v1][v2]) {
				matrix[v1][v2]=cost;
			}
		}
	}	
}


public class graph_11404_�÷��̵� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start;
		int end;
		int cost;
		
		Scanner sc=new Scanner(System.in);
		int cNum=sc.nextInt();
		AdjMatrix adj=new AdjMatrix(cNum); 
		int costNum=sc.nextInt();
		
		for(int i=0;i<costNum;i++) {
			start=sc.nextInt();
			end=sc.nextInt();
			cost=sc.nextInt();
			adj.insertEdge(start, end, cost);
		}
		
		// Do Floyd-Warshall Algorithm
	    for (int k =1; k < cNum+1; k++)	//����
	    {
	        for (int i = 1; i < cNum+1; i++)	//���
	        {
	            for (int j = 1; j < cNum+1; j++)	//����
	            {	//�����Ѱ� �� ������ �������� �ּҰ�����
	                if (adj.matrix[i][j] > adj.matrix[i][k] + adj.matrix[k][j]) 
	                {
	                	adj.matrix[i][j] = adj.matrix[i][k] + adj.matrix[k][j];
	                }
	            }
	        }
	    }
	    
	    for(int i=1;i<cNum+1;i++) {
			for(int j=1;j<cNum+1;j++) {
				System.out.print(adj.matrix[i][j]+" ");
			}
			System.out.println();
		}

	}
}
