package Perform;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testaccess_scd {

	public static void testfile() throws IOException {
	BufferedReader br = new BufferedReader( new FileReader("fifthwebsiteattempt/testaccess.txt"));
	System.out.print(br.readLine());
	}
}
