package dp;

import java.util.Scanner;

class Fish{
		int[] dp;	// ������ �ּұݾ� dp
		Fish(int tc) {
			dp=new int[tc+1];
		}
		public int fishFunc(int[] money,int tc) {
			for(int i=1;i<=tc;i++) {
				for(int j=1;j<=i;j++) {			
					if(dp[i]<money[j]+dp[i-j]) {	//���� dp������ Ȱ���Ͽ� ���� tc�� ����  dp�� ����
						dp[i]=money[j]+dp[i-j];
					}
				}
			}
			return dp[tc];
		}
}

public class dp_11052_�ؾ�Ǹ��ϱ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		int[] money=new int[tc+1];
		for(int i=1;i<tc;i++) {
			money[i]=sc.nextInt();
		}
		Fish fish=new Fish(tc);
		int result=fish.fishFunc(money,tc);
		System.out.println(result);
	}
}