import java.util.*;

public class third1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int max = 0; // ����� ���ĵ� �ִ��� �� 3,5,6 ��ü N���� ��
		int a[] = new int[N];
		int d[] = new int[N];
		
		for(int i=0;i<N;i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++){
			d[i] = 1; //1�� �ʱ�ȭ
			for(int j=0;j<i;j++)
				if(a[j]<a[i] && d[i] < d[j]+1) d[i]++;
			if(max < d[i]) max = d[i];
		}
		System.out.println(N-max);
	}
}