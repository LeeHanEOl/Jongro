import java.util.Scanner;

class Good {
	int max;
	int min=9999999;
	public Good(int num) {
		this.max=num;
	}
	
	public void goodFunc(String good,int depth) {
		
		if(depth==1) {
			goodFunc(good+'2',depth+1);
		}
		
		if(depth>1) {
			if(isGood(good,depth)) {					// ������������ �Ǻ�
				if(max!=depth) {					
					for(char z='1';z<='3';z++) {	// ���������� 1 or 2 or 3 �����鼭 ��͹ݺ�
						if(good.indexOf(z,depth-1)<0) {
							goodFunc(good+z,depth+1);
						}
					}
				} else {
					 if(min>Integer.parseInt(good)) {
							min=Integer.parseInt(good);
					 }
				}
			}
		}
	     
	}
	
	public boolean isGood(String good,int c) {		//���� �������� �Ǻ��Լ�
		
		for(int i=1;i<=c/2;i++) {                   //���ݸ�ŭ���� �ڸ��鼭 ��
			if(good.substring(c-i,c).equals(good.substring(c-(2*i),c-i))) {
				return false;						//������ �������� �ƴϹǷ� false
			} 
		}
		return true;								//���� �ٸ��� ���������̹Ƿ� true
	}

}

public class noBt_2661_�������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		Good g=new Good(num);
		String good="1";
		g.goodFunc(good,1);
		System.out.println(g.min);
	}
}