/*
 * dp�� ���� �׳� Ǭ��
 */

import java.util.Scanner;

class Up {
	public int upFunc(int num) {
		int count=0;
		int one_Count=10;						//1���ڸ��� ����� �׳� ������ ����
		for(Integer i=1;i<Math.pow(10,num);i++) {  // num�� �����μ� ������
			String temp=i.toString();			   // String������ �����ؼ�
			for(int j=0;j<temp.length()-1;j++) {   // ���� �ڸ����ڶ� ��	
				if(temp.charAt(j)>temp.charAt(j+1)) {	//���ڸ��� ũ�� break;
					break;
				} else if(j==temp.length()-2) {         //���� ���ڸ����� �񱳰� �������� ī��Ʈ
					count++;
				}
			}
		}
		return count+one_Count;
	}
}


public class Up_11057_Nodp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Up u=new Up();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int result=u.upFunc(num);
		System.out.println(result);
	}
}
