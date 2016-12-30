import java.util.Scanner;

class MoveC {
	int max=0;   //���� ĵ�� �ִ밪
	int candy=0; //���� ���� ��������
	
	public int moveFunc(int[][] index,int i,int j) {
		candy+=index[i][j]; //�ڱ��ڸ� ĵ��Ա�
		
		if(i+1<index.length) {  //��������� �̵��ϸ鼭 ĵ�� �Դ´�.
			candy=moveFunc(index,i+1,j);
		} else if(j+1<index[0].length) {
			candy=moveFunc(index,i,j+1);
		} else if(i+1<index.length && j+1<index[0].length) {
			candy=moveFunc(index,i+1,j+1);
		}
		if(candy>max) {   // ���� ���� ĵ�� max���� ũ��
			max=candy;
			return max;   //max���� �����ϰ� return;	  
		}
		return candy;
	}
}

public class Move {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveC movec=new MoveC();
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		int c=sc.nextInt();
		
		int[][] index=new int[s][c];
		for(int i=0;i<s;i++) {
			for(int j=0;j<c;j++) {
				index[i][j]=sc.nextInt();
			}
		}
		int result=movec.moveFunc(index,0,0);
		System.out.println(result);
	}
}
