import java.io.*;

public class MyCat
{
	public static void main(String[] args)
	{
		try{
		    FileReader fr = new FileReader(args[0]); // ファイルを開く.
		    BufferedReader br = new BufferedReader(fr);
		    String buf;
		    while ((buf = br.readLine()) != null) // 1行読み込み, それがnullでなければ,
		    {
			System.out.println(buf); // bufを処理する(この例では表示するだけ).
		    }
		    br.close();
		    fr.close(); // ファイルを閉じる.
		}
		catch (IOException e) // もしエラーが起きたら,
		{
		    System.out.println("ファイル読み込みエラー");
		    System.exit(1); // 実行終了
		}	
	}
}
		
