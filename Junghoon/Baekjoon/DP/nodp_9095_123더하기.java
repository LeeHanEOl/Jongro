import java.util.Scanner;

class Cal {
	int[] count;
	
	public Boolean cal(int num) {  
		int list[]=new int[num];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<num;i++) {
			list[i]=sc.nextInt();
			if(list[i]<11) {
				continue;
			} else {
				return false;
			}
		}
		for(int i=0;i<list.length;i++) {		
			count=new int[list.length];
			count[i]=func2(list[i],i);
			System.out.println(count[i]);
		}
		return true;
	}
	
	public int func2(int a,int i) { 
		if(a==0){				//  ��������� ���ٰ� �A���� 0�̸�(���� �����Ǹ�)
			return count[i]++;  //  ������� count���� ++
		} else if (a<0) {       //  ��������� ���ٰ� �A���� 0�� �ȵǸ�(���� �������� ������)
			return 0;
		}
		func2(a-1,i);			//�Էµ� ���� ������ ��������� 1~3�� �A��.
		func2(a-2,i);
		func2(a-3,i);
		return count[i];
	}
}

public class nodp_9095_123���ϱ� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cal cal=new Cal();
		Scanner sc=new Scanner(System.in);
		Boolean flag=false;
			
			while(true) {
				if(flag==true) {
					break;
				} else {
					int num=sc.nextInt();
					flag=cal.cal(num);
				}
			}
	}
}