/*
 * 
 * �Էµ� ���� n�� �ִٸ� �̸� ǥ���ϴ� ���� (n-1)+1 / (n-2)+2 / (n-3)+3 ���� ǥ�� �� �� �ִ�.
 * �̴� ������ ��� 1,2,3�� ������ ��� n�� �ϼ��ȴٰ� �� �� �����Ƿ�
 * n�� 1,2,3���� ���� �� �ִ� ����� ����  [ n-1�϶� ����� �� +n-2�϶� ����� �� + n-3�϶� ����� �� ] 
 */


import java.util.Scanner;

class Plus {
	
	int[] index=new int[12];
	
	public int plus(int a) {
		index[1]=1;
		index[2]=2;
		index[3]=4;
		for(int i=4;i<=a;i++) {
			index[a]=plus(a-1)+plus(a-2)+plus(a-3);
		}
		return index[a];
	}
}


public class dp_9095_123���ϱ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plus p=new Plus();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] tc=new int[num];
		for(int i=0;i<num;i++) {
			int j=sc.nextInt();
			tc[i]=p.plus(j);
		}
		for(int i=0;i<num;i++) {
		System.out.println(tc[i]);
		}
	}

}
