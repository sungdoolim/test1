package algorithm_dnaprj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class compare_denov {

	public static void main(String[] args) {
		
		 BufferedReader br;
		 String ref="";
		 double count=0;
		 double ra;
			try {
				br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/mydna.txt"));
					 ref=br.readLine();				            			         		 	        
			         br.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}	
			
			 BufferedReader br2;
			 String ref2="";
				try {
					br2 = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/denov.txt"));
					while(true) {		
					count=0;
					//System.out.println("ref:"+ref.length());
					ref2=br2.readLine();
					if(ref2==null)
						break;
					//System.out.println("ref2:"+ref2.length());
					for(int i=0;i<ref.length()-1;i++) {
						if(ref.charAt(i)!=ref2.charAt(i)){
								count++;}
							}
					
					 ra=(count/500000)*100;//50000개만 해보까--------------------------------------------------
						if(ra<100) {
						 System.out.println("reference mydna는 "+count+"개의 불일치를 가집니다");
						System.out.println("오차율 : "+ra+"% 입니다");	// 여기는 x%로 잘 만들어 졌는지를 확인합니다.
						}
					
					
				}
				         br2.close();
				} catch ( IOException e) {
					e.printStackTrace();
				}	
				
				
				
				
//				String reftmp=ref2.substring(0, 5000);
//
//				System.out.println(ref.length());
//				int COUNT=ref2.length()/ref.length();
//				System.out.println();
//				System.out.println(reftmp.length());
//				
//				for(int i=0;i<ref.length();i++) {
//					if(ref.charAt(i)!=reftmp.charAt(i)){
//							count++;}
//						}
//					double ra=(count/5000)*100;//50000개만 해보까--------------------------------------------------
//					System.out.println("reference mydna는 "+count+"개의 불일치를 가집니다");
//					
//					System.out.println("오차율 : "+ra+"% 입니다");	// 여기는 x%로 잘 만들어 졌는지를 확인합니다.
//
//					
//					for(int j=0;j<COUNT;j++) {
//					//	System.out.println(ref2.length());
//					//	System.out.println(j);
//						 reftmp=ref2.substring(5000*j, 5000*(j+1));
//					//	System.out.println(ref.length());
//						//System.out.println(reftmp.length());
//						 count=0;
//						for(int i=0;i<ref.length();i++) {
//							if(ref.charAt(i)!=reftmp.charAt(i)){
//									count++;}
//								}
//							 ra=(count/5000)*100;//50000개만 해보까--------------------------------------------------
//							if(ra<73) {
//							 System.out.println("reference mydna는 "+count+"개의 불일치를 가집니다");
//							System.out.println("오차율 : "+ra+"% 입니다");	// 여기는 x%로 잘 만들어 졌는지를 확인합니다.
//							}
//						
//					}
//					
		
	}
}
