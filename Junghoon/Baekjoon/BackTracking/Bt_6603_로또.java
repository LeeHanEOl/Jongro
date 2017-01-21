import java.util.Scanner;

class Lotto {
	int max;
	
	public Lotto(int max) {
		this.max=max;
	}
	
	public void lottoFunc(int[] arr,Boolean[] arrBool,int depth,int num) {
		
		if(depth>5) {							//��� �ζǹ�ȣ�� ���õǾ�����
			for(int z=0;z<max;z++) {
				if(arrBool[z]) {
					System.out.print(arr[z]+" ");
				}
			}
			System.out.println("");
			return;
		}
		
		if(num>max-1) {						   //�ε��� ���ù������� �Ѿ����
			return;
		}
		
		if(!arrBool[num]) {					  //���� �ȵ�����
			arrBool[num]=true;				  //����
			lottoFunc(arr,arrBool,depth+1,num+1);		
			
			arrBool[num]=false;							//�ٽ� ���ƿ��鼭 false��
		}
		lottoFunc(arr,arrBool,depth,num+1); 		   //���õǾ������� �׳� ���� �ε�����	
	}
}
public class Bt_6603_�ζ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=1;
		while(num!=0) {
			num=sc.nextInt();
			int[] arr=new int[num];
			Boolean[] arrBool=new Boolean[num];
			Lotto lotto=new Lotto(num);
			for(int i=0;i<num;i++) {
				arrBool[i]=false;
				arr[i]=sc.nextInt();
			}
			lotto.lottoFunc(arr,arrBool,0,0);
		}
	}

}
