package question_3_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 標準入力から行を取得
		Scanner sc = new Scanner(System.in);
		
		// 対象座標を取得。RとCは1始まりなので、要素番号と合うように-1して格納
		String[] inputStr = sc.nextLine().split(" ");
		int targetRow = Integer.parseInt(inputStr[0]) - 1;
		int targetColmun = Integer.parseInt(inputStr[1]) - 1;
		
		// 変更対象の文字を取得。文字列を文字配列に変換し、必ず1文字しか与えられないので、0番目の要素だけ取得
		char targetChar = inputStr[2].toCharArray()[0];
		
		// 入力の高さと幅の値を取得
		inputStr = sc.nextLine().split(" ");
		int height = Integer.parseInt(inputStr[0]);
		int width = Integer.parseInt(inputStr[1]);
		
		// 入力された図をリストに格納
		ArrayList<ArrayList<Character>> inputList = new ArrayList<ArrayList<Character>>();
		for (int i = 0; i < height; i++) {
			
			// 今回の入力行を文字配列として取得
			char[] nowInputChar = sc.nextLine().toCharArray();
			
			// 文字を1つずつリストに詰め替え
			ArrayList<Character> nowList = new ArrayList<Character>();
			for (char nowChar : nowInputChar) {
				nowList.add(nowChar);
			}
			
			// 今回の入力行リストを、リストに格納
			inputList.add(nowList);
		}
		
		// 入力のクローズ
		sc.close();
			
		// 塗りつぶし開始
		fillImage(inputList, targetRow, targetColmun, targetChar);
		
		// 塗りつぶし結果を出力
		for (ArrayList<Character> nowCharList : inputList) {
			
			for (char nowChar : nowCharList) {
				
				// 今の文字を出力（改行なし）
				System.out.print(nowChar);
			}
			
			// 改行する
			System.out.println();
		}
		
	}
	
	// 塗り潰し用のメソッド
	public static void fillImage(ArrayList<ArrayList<Character>> inputList, int targetR, int targetC, char fillChar) {
		
		if (targetR < 0 || inputList.size() <= targetR) {
			// 行が外なので終了
			return;
		}
		
		if (targetC < 0 || inputList.get(targetR).size() <= targetC) {
			// 列が外なので終了
			return;
		}
		
		if (inputList.get(targetR).get(targetC) == fillChar){
			// 既に塗る色になってるので終了
			return;
		}
		
		// 色を塗る（対象の文字に置き換える）
		inputList.get(targetR).set(targetC, fillChar);
		
		// 上下左右の分、再帰的に呼び出す
		fillImage(inputList, targetR - 1, targetC, fillChar);
		fillImage(inputList, targetR + 1, targetC, fillChar);
		fillImage(inputList, targetR, targetC - 1, fillChar);
		fillImage(inputList, targetR, targetC + 1, fillChar);
		
	}

}
