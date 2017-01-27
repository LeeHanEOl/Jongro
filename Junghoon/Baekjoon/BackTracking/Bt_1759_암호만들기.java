package bt;

import java.util.ArrayList;
import java.util.Scanner;

class Password {
	ArrayList<String> fin=new ArrayList<String>(); //���� ���� arrayList
	char result[];
	char tc[];
	int ja=0;
	int mo=0;
	Password(int l,int c) {
		result=new char[c];
		tc=new char[l];
	}
	
	public void sort() {						// �Լ� ���������� sort
		char temp;
		for(int i=0;i<result.length-1;i++) {
			for(int j=i+1;j<result.length;j++) {
				if((int)result[i]>(int)result[j]) {
					temp=result[j];
					result[j]=result[i];
					result[i]=temp;
				}
			}
		}
	}
	
	public void passFunc(int start,int depth) {		// dfs
		if(tc.length==depth) {						//�������� ��ȣ ���� Ȯ��
			for(int i=0;i<tc.length;i++) {
				if(tc[i]=='a' || tc[i]=='e' || tc[i]=='i' || tc[i]=='o' || tc[i]=='u') {
					mo++;
				} else {
					ja++;
				}
			}
			if(mo>=1 && ja>=2) {
				String temp="";
				for(int i=0;i<tc.length;i++) {
					temp+=tc[i];
				}
				fin.add(temp);
			}
			mo=0;
			ja=0;
			return;
		} 
		
		if(tc.length<depth){					//depth�Ѿ�°��
			return;
		}
		
		for(int i=start;i<result.length;i++) {		//�ϳ��� �߰��ϸ鼭 ���
			tc[depth]=result[i];
			passFunc(i+1,depth+1);
		}
	}
}

public class Bt_1759_��ȣ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int l=sc.nextInt();
		int c=sc.nextInt();
		Password pass=new Password(l,c);
		for(int i=0;i<c;i++){
			pass.result[i]=sc.next().charAt(0);
		}
		pass.sort();
		for(int j=0;j<=c-l;j++) {
			pass.tc[0]=pass.result[j];
			pass.passFunc(j+1,1);
		}
		
		for(int i=0;i<pass.fin.size();i++) {
			System.out.print(pass.fin.get(i));
			if(i!=pass.fin.size()-1) {
				System.out.println("");
			}
		}
	}
}