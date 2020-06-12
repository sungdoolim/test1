package algorithm_dnaprj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class prj {

static int COUNT=0;
static int DENOVCOUNT=0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList shortread=fileshort(50000);//30 * 20000 // 30 30000

		int r=sc.nextInt(); // 몇개까지 일치하면 합칠까?
		String result=brute(shortread,r);
		System.out.println(COUNT);
	}

	
	@SuppressWarnings("unchecked")
	static String brute(ArrayList<String>shortread,int r) throws IOException {
		String result="";
		ArrayList<String> shorttmp;
		int len=shortread.size();
		System.out.println("length = "+len);
		//System.out.println(shortread.size());
		for(int i=0;i<len;i++) {
			
				System.out.println(i+"번째");
			
			shorttmp=(ArrayList<String>) shortread.clone();
		//	len=shorttmp.size();
			String res=shorttmp.get(i);
			shorttmp.remove(i);
			
			denov(shorttmp,res,i,r);
		}
		
		
		
		return result;
	}
	static String denov(ArrayList<String> shorttmp,String res,int i, int r) throws IOException {
		int len_short=500;//short의 길이---------------------------------------
		//String start=shorttmp.get(i);
		//shorttmp.remove(i);
		
		//500/15/250/5
		//5000/50/500/
		// 100/250
		//50/1000
		//
		//50000/300/300
		//100/2500
		//150/600
		//300/1000
		//200/2000/7
		//500000/ 400/10000
		//400/5000
		//500/3000
		//1000/1000
		//300/3000
		//500/20000/200
		
		
		
		DENOVCOUNT++;
		String result=res;
	

		if(DENOVCOUNT%100==0) 
		{System.out.println("count: "+DENOVCOUNT+", "+result.length());}
		String compare;
		String subtmp;
		String subtmp2;String subtmp3;
		int d,j;
		ArrayList<String>tmp;
		int len=shorttmp.size();
		int rindex;
		int rl;
		
		int subrl;
	//	System.out.println(len);
		for(j=0;j<shorttmp.size();j++) {
			
			if(result.length()>=500000)
				break;
			
			compare=shorttmp.get(j);
			
			subtmp=compare.substring(0,r);
			subtmp2=compare.substring(r);
			
			if(result.contains(subtmp)) {
				
				//int rindex=result.indexOf(subtmp);
				 rindex=result.lastIndexOf(subtmp);
				 rl=result.length();
				
				 subrl=rl-rindex;
				if(subrl==r) {
					
					result+=subtmp2;
					tmp=(ArrayList<String>) shorttmp.clone();
					
					tmp.remove(j);len--;
					 denov(tmp,result,j,r);
					
					
				}else if(subrl<len_short&&subrl>r) {
					d=subrl-r;
					subtmp3=subtmp2.substring(0,d);
					if(result.substring(rl-d).equals(subtmp3)) {
						result+=subtmp2.substring(d);
						
						tmp=(ArrayList<String>) shorttmp.clone();
						
						tmp.remove(j);len--;
						 denov(tmp,result,j,r);
					//	shorttmp.remove(j);len--;
					//	 denov(tmp,result,j,r);
					}

				}
				else {
					continue;
				}   
				
			
				
		}}
		if(result.length()>=500000) {	
			
			COUNT++;
			
			try {	
				BufferedWriter bw=new BufferedWriter(new FileWriter("C:/Users/bohee/Desktop/denov.txt",true));
			  PrintWriter pw;
					pw = new PrintWriter(bw,true);
					
					pw.println(result);
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		System.out.println(result.length()+"denov 쓰기 완료----------------------------------------");
		
			return result;
			
		}
		return "";
		
	}
	
	
	static ArrayList<String> fileshort(int n) {
		ArrayList<String> strlist=new ArrayList<String>();
		 BufferedReader br;
	//	String []shortread=new String[n];
		try {
			String str;
			br = new BufferedReader(new FileReader("C:/Users/bohee/Desktop/shortread.txt"));
		//	int i=0;
			while(true) {
				 str=br.readLine();	
				 if(str==null)
				 { break;}
	//	shortread[i]=str;
		strlist.add(str);
	//	i++;
			}br.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}
		//return shortread;
	
		return strlist;
	}
	
}
