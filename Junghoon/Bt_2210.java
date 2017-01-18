import java.util.HashSet;
import java.util.Scanner;

class Jump {
	
	HashSet result_set=new HashSet(); //�ߺ��� ���� ����ʴ� set
	
	public void jumpFunc(int[][] matrix,int i,int j,int depth,int result) {
		 
		 if(depth>=6) {								//6�ڸ� ���ڸ��������
		      	 result_set.add(result);            //set�� add
		 }
		   
		 result+=result*10+matrix[i][j];			// ���� �ε������� ��������
		 if(i<4) jumpFunc(matrix,i+1,j, depth+1,result);	//��������� �ε����̵�
		 if(j<4) jumpFunc(matrix,i,j+1, depth+1,result);
		 if(i>0) jumpFunc(matrix,i-1,j, depth+1,result);
		 if(j>0) jumpFunc(matrix,i,j-1, depth+1,result);
	}
}

public class Bt_2210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix=new int [5][5];
		Scanner sc=new Scanner(System.in);
		Jump jump=new Jump();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				jump.jumpFunc(matrix,i,j,0,0);
			}
		}
		System.out.println(jump.result_set.size());  // set�� ���� ���
	}
}
