import java.util.Scanner;

class LongDe{
	int max;
	int l=0;
	
	public LongDe(int max) {
		this.max=max;
	}
	
	public void DFunc(int[] arr,int point,int num,int count){
		
		for(int i=num;i<max;i++) {			//point ���� �������� point���� ���� �� �ִ��� Ȯ��
			if(arr[i]-point<0) {			
				DFunc(arr,arr[i],i+1,count+1);		//������ �������� point�� �ٲٰ� ��͹ݺ�
			} 
		}
		
		if(l<count) {							    //���� ū �κм����� ����
			l=count;
		}
	}
}

public class dp_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] arr=new int[num];
		LongDe ld=new LongDe(num);
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int j=0;j<num;j++) {				//�κй迭�� ���� ����
			ld.DFunc(arr,arr[j],j+1,1);
		}
		System.out.println(ld.l);
	}
}