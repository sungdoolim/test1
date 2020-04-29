//2015112120 임성두
package week5;

public class no2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M=11;
		int Mar[]=new int[M+1];
		int c1=1,c2=4,c3=7;
		coinDynamic(Mar,M,c1,c2,c3);

	}
	static void coinDynamic(int Mar[],int M,int c1,int c2,int c3) {
		int t1=0,t2=0,t3=0;
		for(int i=0;i<=M;i++) {
			if(i-c3>=0) {
			t1=Mar[i-c1]+1;
			t2=Mar[i-c2]+1;
			t3=Mar[i-c3]+1;
			}else if(i-c2>=0) {
				t1=Mar[i-c1]+1;
				t2=Mar[i-c2]+1;
				t3=10000;
			}else if(i-c1>=0){
				t1=Mar[i-c1]+1;
				t2=10000;
				t3=10000;
			}
			Mar[i]=min(t1,t2,t3);
			
			
			System.out.println("M="+i+"\n"+Mar[i]+" ");
			
		}
	}/*
	위는 핵심 코드입니다. 
Mar 배열은 인덱스를 구성하는 최소의 조합수를 저장하게 됩니다.
c1 c2 c3가 주어지면 인덱스에서 c1,c2,c3를 뺀 인덱스의 최소값에 1을 더하고,
각 값의 최소값이 인덱스를 구성하는 최소의 조합이 됩니다.
예외처리로는 배열의 인덱스를 넘어서게 되면 ‘큰 값’을 넣어 min연산 시 절대 나오지 않을 수 있게 처리하려는 것이 아이디어입니다.(임의의 ‘큰 값’ 10000을 넣었습니다)
 

*/
	static int min(int a,int b,int c) {
		// 세 수를 단순 비교하여 max값을 리턴합니다.
		int min=a;
		if(min>b)
			min=b;
		
		if(min>c)
			min=c;
		
		return min;
		
	}

}