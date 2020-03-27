//2015112120 임성두
package week2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class no1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 비순환  회문 알고리즘
		 try{
	            //파일 객체 생성
	            File file = new File("C:\\Users\\bohee\\Desktop\\sample.txt");
	            //입력 스트림 생성, 파일을  한줄 씩 읽어 옵니다
	            FileReader filereader = new FileReader(file);
	            //입력 버퍼 생성
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	                // 파일에 모든 문자를 읽어 올때 까지 ispal 메서드를 실행합니다
	                System.out.println(ispal(line));

	                
	            }
	            //.readLine()은 끝에 개행문자를 읽지 않습니다.            
	            bufReader.close();
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }


	}
	
	static boolean ispal(String s) {
		int len=s.length();
		boolean b=true;
		for(int i=0;i<len/2;i++) {// 회문인지 아닌지를 문자열의 인덱스 비교로 확인합니다.
			if(s.charAt(i)==s.charAt(len-i-1)) {
				continue;
			}else {
				b=false;
				break;
			}
		}
		return b;
		
	}
	

}
/*
 * 
for(input_file){
	
	s <- input_file_line
	length=s.length
	Len= length/2
	print(ispal(s,Len,length)


	}

is pal(s,Len,length){
	for(i=0~Len; i++){
		if(s[i]!=s[length-i-1]){return false}
		}return true;
}


 */

