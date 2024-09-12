package question_4_1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		// 標準入力から行を取得
		Scanner sc = new Scanner(System.in);
		
		// 取得した標準入力の文字列をスペース区切りで分割して、それぞれをintに変換しつつ変数に格納
		List<Integer> inputList = Arrays.stream(sc.nextLine().split(" ")).map( x -> Integer.parseInt(x)).collect(Collectors.toList());
		
		// 入力クローズ
		sc.close();
		
		
		// dp配列の作成。0で初期化された状態のまま使う
		int[] dpArray = new int[inputList.size() + 1];
		
		// 最初の位置は移動にコストが掛からない（コスト0が自明）ので、2個目（要素1）の地点から考える
		for(int i = 1; i < inputList.size(); i++) {
			
			// dp表は1個ずれてるので、分かりやすいように座標用変数を設定
			int dpPos = i + 1;
			
			// 1個前から移動してきた場合の最小コストを算出
			int oneJumpCost = dpArray[dpPos - 1] + Math.abs(inputList.get(i - 1) - inputList.get(i));
			
			// 2個前から移動してきた場合の最小コストを算出
			// 2個目の地点の場合は2個前から飛んでくることができないので、2個前がある場合だけちゃんと算出し、2個前がないならあり得なさそうな高コストにする
			int twoJumpCost = 999999999;
			if (2 <= i) {
				twoJumpCost = dpArray[dpPos - 2] + Math.abs(inputList.get(i - 2) - inputList.get(i));
			}
			
			// 今回の移動として、1個前と2個前、よりコストの低い方を採用
			dpArray[dpPos] = oneJumpCost < twoJumpCost ? oneJumpCost : twoJumpCost;
			
		}
		
		// 今回の結果を出力
		System.out.println(dpArray[dpArray.length - 1]);
		
		
	}

}
