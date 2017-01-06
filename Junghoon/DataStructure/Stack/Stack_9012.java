import java.util.Scanner;
import java.util.LinkedList;

class G {
	
	public String function(String a) {
		LinkedList l=new LinkedList();	//���û���
		for(int i=0;i<a.length();i++) {		//���ڿ��� �����ϳ��� for��
			if(a.charAt(i)=='(') {			// ���ڰ� '('�̸�
				l.add('(');					// ���ÿ� push
				
			} else if(a.charAt(i)==')' && l.size()>0) { 
				l.removeLast();// ���ڰ� ')'�̰�  ���õ����� ������ 0�̻��̸� pop
			} else if(a.charAt(i)==')' && l.size()<=0) {
				return "NO";   // ���ڰ� ')'�ε� ���õ�����('(')�� ���� ���
							   // NO ����
			}
		}
		
		if(l.size()==0) {
			return "YES";	   // for�� �� ���� ���ÿ� �ƹ��͵� ������ YES
		}
		
		return "NO";		   // �� �̿��� ���� ��� NO
	}
}

public class Stack_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		G g=new G();
		int t=Integer.parseInt(sc.nextLine());
		String[] result=new String[t];
		for(int i=0;i<t;i++) {
			String a=sc.nextLine();
			result[i]=g.function(a);
		}
		
		for(int j=0;j<t;j++) {
			System.out.println(result[j]);
		}
	}

}
