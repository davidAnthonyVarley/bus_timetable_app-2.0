import java.io.BufferedReader;

public class x {
	public static void testfile() {
		BufferedReader br = new BufferedReader( new FileReader("fifthwebsiteattempt/testaccess.txt"));
		System.out.print(br.readLine());
	}
}