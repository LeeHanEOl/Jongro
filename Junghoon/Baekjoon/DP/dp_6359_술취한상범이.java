import java.util.Scanner;

class Gam {
	
	int countNum;
	
	public Gam(int count) {
		this.countNum=count;
	}
	
	public int gamFunc(Boolean[] room,int num) {
		/*
		 *  room-������ �������� / num-��� �پ���� ���ΰ�
		 */
		
		while(num<=countNum) {				 // �ο�����ŭ
			for(int i=1;i<=countNum/num;i++) {
				if(room[i*num] == true) {	 // ���� ����, ������ ��װ�
				   room[i*num]=false;	
				} else {
					room[i*num]=true;
				}
			}
			num++;						
		}
		
		int result=0;
		for(int i=1;i<=countNum;i++) {		 // �����͸� ī��Ʈ 
			if(room[i]==true) {
				result++;
			}
		}
		
		return result;
	}
}


public class dp_6359 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		for(int i=0;i<num;i++) {
			int count=sc.nextInt();
			Boolean[] room=new Boolean[count+1];
			for(int j=1;j<=count;j++) {
				room[j]=false;
			}
			Gam gam=new Gam(count);
			int result=gam.gamFunc(room,1);
			System.out.println(result);
		}

	}

}
