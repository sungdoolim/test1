package algorithm_dnaprj;
//2015112120 임성두
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class trivial {

	static void triv(int k,int n,int l) {
		int y=k/10;
		char[]dna= {'A','G','C','T'};
		String ref=inputfile();// 위에서 쓴 파일을 불러옵니다
		StringBuilder strref=new StringBuilder(ref);
		StringBuilder strref2=new StringBuilder(ref);// strref는 데이터가 변경되기에 strref2를 따로 만들었습니다.
		//String []shortread=makeShortread(strref, k, n,10,dna);
		ArrayList<String>shortread=fileshort();
		//writeShortread(shortread);// shortread를 파일에 씁니다
		//shortread=fileshort();// 위에서 쓴 파일을 불러옵니다
		String str = filemydna();//makeShortread메서드에서 파일로 저장한 파일을 불러옵니다.

		double count=0;
		for(int i=0;i<ref.length();i++) {
			if(str.charAt(i)!=ref.charAt(i)){
					count++;}
				}
			double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기					
			StringBuilder mydna=makeMyDna(strref2,k,n,y,dna,shortread);
			double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
			double msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
			
			// 이 밑은 결과를 출력하고 output파일을 만들 뿐입니다.
			
				 count=0;
				beforeTime=System.currentTimeMillis();
				for(int i=0;i<ref.length();i++) {
					if(str.charAt(i)!=mydna.charAt(i)){
						count++;
					}
				}System.out.println("Difference Count : "+count);
				double ra=((l-count)/l)*100;
				System.out.println("Accuracy : "+ra+"%");
		     	System.out.println("Excuting Time : "+msecDiffTime/1000+"seconds");
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String ref ="";
		char[]dna= {'A','G','C','T'};
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();//30
		int n=sc.nextInt();//20000
		double y=sc.nextDouble();
		
		writefile(dna);// 50만길이의 dna를 파일에 씁니다

		ref=inputfile();// 위에서 쓴 파일을 불러옵니다
		StringBuilder strref=new StringBuilder(ref);
		StringBuilder strref2=new StringBuilder(ref);// strref는 데이터가 변경되기에 strref2를 따로 만들었습니다.
		String []shortread=makeShortread(strref, k, n,10,dna);
		writeShortread(shortread);// shortread를 파일에 씁니다
		shortread=fileshort(n);// 위에서 쓴 파일을 불러옵니다
		String str = filemydna();//makeShortread메서드에서 파일로 저장한 파일을 불러옵니다.

		double count=0;
		for(int i=0;i<ref.length();i++) {
			if(str.charAt(i)!=ref.charAt(i)){
					count++;}
				}
			double ra=(count/500000)*100;//50000개만 해보까--------------------------------------------------
			System.out.println("reference mydna는 "+count+"개의 불일치를 가집니다");
			 ra=(count/500000)*100;
			System.out.println("오차율 : "+ra+"% 입니다");	// 여기는 x%로 잘 만들어 졌는지를 확인합니다.

			long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기					
			StringBuilder mydna=makeMyDna(strref2,k,n,y,dna,shortread);
			long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
			long msecDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
			
			// 이 밑은 결과를 출력하고 output파일을 만들 뿐입니다.
			
			System.out.println("\n"+msecDiffTime/1000+"초의 시간이 걸렸습니다.");
			count=0;
			for(int i=0;i<ref.length();i++) {
				if(ref.charAt(i)!=mydna.charAt(i)){
					count++;
				}
			}System.out.println(" 복구한 mydna는 ref와 "+count+"개의 불일치를 가집니다");
				fileoutput(mydna);
				ra=(count/500000)*100;
				System.out.println(" 오차율 : "+ra+"% 입니다");
				 count=0;
				beforeTime=System.currentTimeMillis();
				for(int i=0;i<ref.length();i++) {
					if(str.charAt(i)!=mydna.charAt(i)){
						count++;
					}
				}System.out.println("복구한 dna는 mydna와 "+count+"개의 불일치");
				 ra=(count/500000)*100;
				System.out.println("복구한 dna와 mydna의 오차율 : "+ra+"%입니다");
				sc.close();	
	}
	
	
	// 맨 밑에부터 두개의 메서드를 제외하면 전부 file 입출력 메서드로 큰 의미를 가지지 않습니다.
	// 맨 밑 두개는 makeShortread 메서드와 makeMyDna 메서드를 말합니다
	
	
	*/
	
	static void fileoutput(StringBuilder mydna) {
		try {	
			  PrintWriter pw;
					pw = new PrintWriter("trivial.txt");
		            pw.print(mydna);
				    pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}//결과를 파일로 저장합니다.
	}
	
	static String filemydna() {
		 BufferedReader br;
		 String str="";
		try {
			br = new BufferedReader(new FileReader("mydna.txt"));
				 str=br.readLine();	
	br.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	 static ArrayList<String> fileshort() {
	        ArrayList<String> strlist=new ArrayList<String>();
	        BufferedReader br;
	        try {
	            String str;
	            br = new BufferedReader(new FileReader("shortread.txt"));
	            while(true) {
	                str=br.readLine();
	                if(str==null)
	                { break;}
	                strlist.add(str);
	            }br.close();
	        } catch ( IOException e) {
	            e.printStackTrace();
	        }
	        return strlist;
	    }
	static String inputfile() {
		 BufferedReader br;
		 String ref="";
			try {
				br = new BufferedReader(new FileReader("ref.txt"));
					 ref=br.readLine();				            			         		 	        
			         br.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}	
			return ref;
	}


	//100000 500 2000 50 
	
	
	
	
	
	static StringBuilder makeMyDna(StringBuilder ref,int k,int n,double y,char[] dna,ArrayList<String> shortread) {
		//int indexcount=0;
		int count=0;
	//	boolean countb=false;
		//int stindex=0;
		int tmp;
		//int rl=ref.length();
		int rlt=ref.length()-k+1;
		int [][]store=new int[(int)y][2];
		for(int stindex=0;stindex<n;stindex++) {
		//	if(stindex%2000==0) {System.out.print(stindex+" ");}
		test:for(int v=0;v<=rlt;v++) {
			
			tmp=v;
			//countb=true;
			count=0;
			for(int stl=0;stl<k;stl++,tmp++) {
				if(shortread.get(stindex).charAt(stl)!=ref.charAt(tmp)) {
					count++;
					if(count>y) {
						continue test;
					}
					store[count-1][0]=stl;
					store[count-1][1]=tmp;
				}
			}

				for(int i=0;i<count;i++)
				{//System.out.println(store[i][1]+","+store[i][0]);
					ref.setCharAt(store[i][1], shortread.get(stindex).charAt(store[i][0]));}
				break;
			}
		}
	
		return ref;
		
	}

}