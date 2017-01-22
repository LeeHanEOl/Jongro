import java.util.*;

public class Baek11404_Floyd {
	public static void main(String[] args) {
		new Baek11404_Floyd();
	}
	
	int N, M;
	int[][] arr;
	
	Baek11404_Floyd() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		
		// i==j �� ��츦 ����, ��� ��θ� �������� ����� ��
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j) arr[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// ������ ����� ���� ������Ŀ� ä������
		for(int cnt=1; cnt<=M; cnt++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = Math.min(arr[a][b],c);
		}
		sc.close();
		
		// �÷��̵�ͼ� �˰��� ���� �� ���
		floyd();
		for(int i=1; i<=N; i++, System.out.println()) {
			for(int j=1; j<=N; j++) {
				System.out.print(arr[i][j] + " "); 
			}
		}
	}
	
	void floyd() {
		for(int k=1; k<=N; k++) { // k�� ���������� �ǹ�
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) { //i->j �� i->k->j �� �� ���� ��θ� ����
					if(arr[i][k]==Integer.MAX_VALUE || arr[k][j]==Integer.MAX_VALUE) continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
	}
}

/*
import java.util.*;

public class Baek11404_Floyd {
	public static void main(String[] args) {
		new Baek11404_Floyd();
	}
	
	int N, M;
	int[][] arr;
	
	Baek11404_Floyd() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		
		for(int cnt=1; cnt<=M; cnt++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = selectShorterPath(arr[a][b],c);
		}
		
		floyd();
		for(int i=1; i<=N; i++, System.out.println()) {
			for(int j=1; j<=N; j++) {
				System.out.print(arr[i][j] + " "); 
			}
		}
		sc.close();
	}
	
	void floyd() {
		for(int k=1; k<=N; k++) { // k�� ���������� �ǹ�
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j || arr[i][k]==0 || arr[k][j]==0) continue; //i->i ����̰ų�, i->k Ȥ�� k->j�� ���� ���̸� �� �Ұ��� 
					arr[i][j] = selectShorterPath(arr[i][j], arr[i][k]+arr[k][j]); // �ٷ� i->j�� ������, �ƴϸ� i->k->j�� ������ ����
				}
			}
		}
	}
	
	int selectShorterPath(int a, int b) {
		if(a==0) return b;
		else if(b==0) return a;
		else if(a>b) return b;
		return a;
	}
}
*/