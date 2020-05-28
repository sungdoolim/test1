package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.Any;

public class bwt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String T="missisippi";
		//String T="acaacg";
		char[] bwt=BWT(T);   /// bwt(t)를 받아 옵니다.
		int bwtl=bwt.length;
		System.out.println("\nBWT(T)의 결과 : ");
		for(int i=0;i<bwtl;i++) {
			System.out.print(bwt[i]);
		}System.out.println();
		String myText=FindMyText(bwt,bwtl);
		
		
		
	}
	static String FindMyText(char[] bwt,int bwtl) {

		char[] bwt_origin=bwt.clone();
		Arrays.sort(bwt);// 알파벳 순서 정렬 
		// sort된 bwt는 처음 열 을 가지게 됩니다. 
		Map<Character,Integer> har=new HashMap<>();
		int count=0;
			for(int i=0;i<bwtl-1;i++) {
			if(bwt[i]==bwt[i+1]) {
			count++;
			continue;
			}else {
				har.put(bwt[i], count);
				count=0;
			}
		}har.put(bwt[bwtl-1], count);
		
		

	
		
		String a="SDfdsf";
//		ArrayList<Object> originbwt=new ArrayList<>();
//		originbwt.add("2");
//		originbwt.add('c');
//		originbwt.add(3);
	//	System.out.println(originbwt.get(2));
		//ArrayList sortedbwt=new ArrayList<>();

		
		//har.put(bwt[i], count);
		
		for(int i=0;i<bwtl;i++) {
			System.out.println(bwt[i]+","+bwt_origin[i]);	
		}		
		return "";
	}
	
	static char[] BWT(String T) {
		
		T="$"+T;
		System.out.println(T+"\n");
		int tl=T.length();
		String []FTRest=new String[tl];
		String tmp1,tmp2;
		
		
		for(int i=tl;i>0;i--) {// Fill the Rest를 만들어 냅니다.
			tmp1=T.substring(0, i);
			tmp2=T.substring(i);
			FTRest[tl-i]=tmp2+tmp1;
		}
		
		

		System.out.println("Fill the Rest : ");
		for(int i=0;i<FTRest.length;i++) {//Fill the Rest출력 결과 입니다.
			System.out.println(FTRest[i]);
		}
		
		
		Arrays.sort(FTRest);
		System.out.println();

		System.out.println("Sorted Fill the Rest : ");
		for(int i=0;i<FTRest.length;i++) {//Fill the Rest를 알파벳 순서로 sort한 결과 출력입니다.
			System.out.println(FTRest[i]);
		}
		
		String bwt="";
		char []bwt2=new char[tl];
		for(int i=0;i<tl;i++) {
			bwt+=FTRest[i].charAt(tl-1);
			bwt2[i]=FTRest[i].charAt(tl-1);
		}
	
		//return bwt;
		return bwt2;
	}
		

}
