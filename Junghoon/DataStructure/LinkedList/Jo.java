import java.util.*;

class Joseb {
	int num=0;
	
	public int func(LinkedList L,int size,int i) {
		int result=0;		
		num=(num+i-1)%size;			//������ index ����
		result=(int)L.remove(num);	// ���ְ� return��(���ذ�)�� ����
		return result;				// return;
	}
}


public class Jo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> L= new LinkedList<Integer>();
		Joseb jo=new Joseb();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int a[]=new int[num];
		for(int i=0;i<num;i++) {
			L.add(i+1);
		}
		int i=sc.nextInt();
		for(int j=0;j<num;j++) {
			a[j]=jo.func(L,L.size(),i);
		}
		
		for(int z=0;z<num;z++) {
			System.out.print(a[z]+" ");
		}
	}
}
