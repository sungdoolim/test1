//2015112120 임성두
package week2;

import java.util.Stack;

public class no3_4 {

	public static void main(String[] args) {
		int []KBubble=new int[1000];		
		int []KQuick=new int[1000];
		for(int i=0;i<1000;i++) {
			KQuick[i]=(int)(Math.random()*10000)+1;
			System.out.print(KQuick[i]+" ");
		}
		int ran=0;
		for(int i=0;i<1000;i++) {
			
			ran=(int)(Math.random()*10000)+1;
			KBubble[i]=ran;
			KQuick[i]=ran;
			System.out.print(KBubble[i]+" ");
		}
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
	      
		bubble(KBubble,KBubble.length);
		
		System.out.println("\n--------------------------------------");
		for(int i=0;i<1000;i++) {
			System.out.print(KBubble[i]+" ");
		}// 1000을 동적할당한 K 배열에 관한 코드 입니다.
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("\n bubble sort 걸린 시간 : "+msecDiffTime);
		
		
		beforeTime = System.currentTimeMillis();

		quick(KQuick,1000);
		System.out.println("\n--------------------------------------");
		for(int i=0;i<1000;i++) {
			System.out.print(KQuick[i]+" ");
		}
		
		 afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		 msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("\n quick sort 걸린 시간 : "+msecDiffTime);
		
	}	
	static void bubble(int[] N,int len) {
		boolean b=true;
		int tmp=0;
		for(int i=0;i<len-1;i++) {
			if(N[i]<N[i+1]) {
				b=false;
				tmp=N[i];
				N[i]=N[i+1];
				N[i+1]=tmp;
			}
		}if(!b) {
			bubble(N,len);
		}

	}
	static void quick(int[]N,int len) {
		Stack<Integer> stack = new Stack<>();
		
	
		int start=0;
		int end=len-1;
		stack.push(end);
		stack.push(start);
		
		int left=0;
		int right=0;
		
		int tmp=0;
		
		while(!stack.isEmpty()) {
		
			start=stack.pop();
	
			end=stack.pop();

			if(start<0||end<0||start>=end)continue;

			while(true) {
	
				left=start+1;
				right=end;
				
			while(N[start]<=N[left]&&left<=end) {
				left++;
				
				if(left>end) {
					left=start;
					break;}
			}
			while(N[start]>=N[right]&&right>start) {
				right--;
				
			}
			if(left<right) {
				
				tmp=N[left];
				N[left]=N[right];
				N[right]=tmp;
			}else if(left==right) {
				
			break;	
			}
			else {
				
				tmp=N[start];
				N[start]=N[right];
				N[right]=tmp;
				stack.push(end);
				stack.push(right+1);
				stack.push(right-1);
				stack.push(start);
				break;
			}
			}
			
		}
	}

}