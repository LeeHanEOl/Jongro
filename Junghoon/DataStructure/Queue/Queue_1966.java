import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Q {
	public int QFunc(int size,int index){       //size- ť������ ������ ���� index- ������� �������� ���� �ε��� 
		int count=0;							//ť���� ���� ���� ī��Ʈ- ������� �������� �������� ����
		LinkedList l=new LinkedList();
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<size;i++) {
			l.add(sc.nextInt());
		}
		while(true) {
			if(l.get(0)==Collections.max(l) && index==0) { //��Ŀ�� ������ �Ű�, �� ������ ���� ���ϴ� �ε����϶�
				l.poll();								   //����	
				count++;								   //ī��Ʈ	
				break;
			} else if(l.get(0)==Collections.max(l)) { //��Ŀ�� �����°�
				l.poll();							  //����
				index=index-1;						  //�ϳ� �������ϱ� ���ϴ� �ε����� -1	
				count++;							  //ī��Ʈ
			} else {								// �������ϴµ� ���� �켱������ ��ũ��
				l.add(l.poll());					// �׳� �ǵڷ� �ѱ�
				if(index==0) {						// �ٵ� �װ��� index���̿��ٸ�
					index=l.size()-1;				// index�� �ǵ� �ε����� �ٲ���
				} else {							// �ƴϸ�
					index=index-1;					// �׳� -1
				}
			}
		}
		return count;
	  }
}


public class Queue_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q=new Q();
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		for(int i=0;i<tc;i++) {
			int size=sc.nextInt();
			int dap=sc.nextInt();
			int result=q.QFunc(size,dap);
			System.out.println(result);
		}
	}
}
