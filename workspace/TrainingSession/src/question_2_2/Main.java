package question_2_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		// 標準入力から行を取得
		Scanner sc = new Scanner(System.in);
		
		// 取得した標準入力の文字列をスペース区切りで分割して、それぞれをintに変換しつつ変数に格納
		// 乗数のリスト
		String[] inputStr = sc.nextLine().split(" ");
		List<Integer> multiplierList = Arrays.stream(inputStr).map( x -> Integer.parseInt(x)).collect(Collectors.toList());
		
		// 被乗数のリスト
		inputStr = sc.nextLine().split(" ");
		List<Integer> multiplicandList = Arrays.stream(inputStr).map( x -> Integer.parseInt(x)).collect(Collectors.toList());
		
		// クローズ
		sc.close();
		
		
		// 各行の最大値を取得
		int multiplierMax = Collections.max(multiplierList);
		int multiplicandMax = Collections.max(multiplicandList);
		
		// 各行の最大値同士を乗算して、最大桁巣を確認
		int maxDigits = String.valueOf(multiplierMax * multiplicandMax).length();
		
		
		// 入力された乗数のリストでループ
		for(int i : multiplierList) {
			
			// 出力用の文字列を定義
			String outputStr = "";
			
			// 入力された被乗数のリストでループ
			for(int j : multiplicandList) {
				
				// 掛け算の結果を取得
				int calcResult = i * j;
				
				// 今回の桁数を取得
				int nowDigits = String.valueOf(calcResult).length();
				
				// 適切な半角スペースを補って結果文字列に結合（最大桁数に足りない分ループ）
				for(int k = nowDigits; k < maxDigits; k++) {
					outputStr += " ";
				}
				
				// 計算結果を結果文字列に結合。数字の区切りのためのスペースも一緒に末尾に付与する
				outputStr += calcResult + " ";
				
			}
			
			// 末尾のスペースは余計なので除去する
			outputStr = outputStr.replaceFirst(" $", "");
			
			// 今回の行の掛け算の結果を出力
			System.out.println(outputStr);
			
		}
		
		
		
	}

}
