package question_1_1;

public class Main {

	public static void main(String[] args) {
		
		// 1から100までループ
		for(int i = 1; i <= 100; i++) {
			
			// 出力用変数の定義
			String outputStr = "";
			
			// 各種判定
			if(i % 3 == 0) {
				// 3の倍数の場合
				outputStr = "Fizz";
			}
			if(i % 5 == 0) {
				// 5の倍数の場合
				outputStr += "Buzz";
			}
			if("".equals(outputStr)) {
				// 出力文字に何も入ってない場合（3の倍数でも5の倍数でもなかったということ）
				outputStr = Integer.toString(i);
			}
			
			// 出力文字を出力
			System.out.println(outputStr);
			
		}
		
		
	}

}
