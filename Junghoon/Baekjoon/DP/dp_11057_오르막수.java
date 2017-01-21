import java.util.Scanner;

class Up {
	public int upFunc(int num) {

		int[][] stair=new int[1000][10];	//[�ڸ���][�ش��ڸ�����]
		int result=0;
		for(int i=0;i<10;i++) {				//�ʱⰪ (0~9����)
			stair[1][i]=1;
		}
		
		for(int i=2;i<=num;i++) {			//�ڸ���(�Է°�)
			for(int j=0;j<10;j++) {			//�ش��ڸ����� ���� j�� ���� for��
				for(int k=j;k<10;k++) {		//�ش��ڸ����� ���� j���� ū ��(�ø���)�鸸 for��
					stair[i][j]+=stair[i-1][k]%10007; // ��������� �Ʒ��ڸ��� ���� ���Ѵ�.
				}
			}
		}
		
		for(int i=0;i<10;i++) {
			result+=stair[num][i];			//�ش� �ڸ����� ���� ��(���� �ڸ��� ���� 1~9����) �� ����
		}

		return result%10007;                // �信�� �䱸�Ѵ�� 10007�� ������ return 
	}
}


public class dp_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Up u=new Up();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int result=u.upFunc(num);
		System.out.println(result);
	}
}
