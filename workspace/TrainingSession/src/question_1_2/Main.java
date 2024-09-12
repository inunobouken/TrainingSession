package question_1_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 標準入力取得用のインスタンス生成
		Scanner sc = new Scanner(System.in);
		
		// 標準入力から、文字列を1行取得
		String inputStr = sc.nextLine();
		
		// 取得した標準入力の文字列をスペース区切りで分割して、それぞれをintに変換しつつ変数に格納
		String[] inputSplitArray = inputStr.split(" "); 
		int start = Integer.parseInt(inputSplitArray[0]);
		int end = Integer.parseInt(inputSplitArray[1]);
		
		// クローズ
		sc.close();
		
		// 入力から受け取った最初から最後まででループ
		for(int i = start; i <= end; i += 2) {
			
			String outputStr = "";
			
			// 各種判定
			if(i % 3 == 0) {
				outputStr = "Fizz";
			}
			if(i % 5 == 0) {
				outputStr += "Buzz";
			}
			if("".equals(outputStr)) {
				outputStr = Integer.toString(i);
			}
			
			// 結果出力
			System.out.println(outputStr);
			
		}
		
		
	}

}
