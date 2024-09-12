package question_2_1;

public class Main {

	public static void main(String[] args) {
		
		// 1から9までループ
		for(int i = 1; i <= 9; i++) {
			
			// 出力用の文字列を定義
			String outputStr = "";
			
			// 1から9までループ
			for(int j = 1; j <= 9; j++) {
				
				// 掛け算の結果を取得
				int calcResult = i * j;
				
				// 適切な半角スペースを補って結果文字列に結合。数字の区切りのためのスペースも一緒に末尾に付与する
				outputStr += (calcResult < 10 ? " " : "") + calcResult + " ";
				
			}
			
			// 末尾のスペースは余計なので除去する
			outputStr = outputStr.replaceFirst(" $", "");
			
			// 今回の行の掛け算の結果を出力
			System.out.println(outputStr);
			
		}
		
		
	}

}
