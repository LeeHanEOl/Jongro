import java.util.Scanner;

/*
 * result=> ������ �ݾ׿� ���� ����� �� �迭
 * typeList=> ���� type�� ���� �迭 
 * m-typeList[n]<0 : �ش� ������ �����ȵ�
 * m-typeList[n]=0 : result[0]=1���� ���� 1-1=0
 * m-typeList[n]>0 : ���� ����(result[m-typeList[n]]�� �ݾ׿� ���� ����)�� ��ħ
 */

class Func2  {
	
	public int func(int type,int money,int[] result,int[] typeList) {
		
		for(int n=1;n<=type;n++) {
			for(int m=1;m<=money;m++) {
				if(m-typeList[n]<0) continue;
				result[m]+=result[m-typeList[n]];
			}
		}
		return result[money]; 
	}
}

public class dp_9084_���� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int type=0;
		int money=0;
		Func2 f=new Func2();
		int[] result=new int[10000+1];
		int[] typeList = null;
		for(int i=0;i<num;i++) {
			type=sc.nextInt();
			typeList=new int[type+1];
			for(int j=1;j<=type;j++) {
				typeList[j]=sc.nextInt();
			}
			result[0]=1;
			money=sc.nextInt();
			int out=f.func(type,money,result,typeList);
			System.out.println(out);
			for(int j=0;j<=money;j++) { 
			result[j]=0;
			}
		}

	}
}
