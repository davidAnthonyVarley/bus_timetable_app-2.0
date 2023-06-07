import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class testaccess_scd {

	public static void testfile(PrintWriter out) throws IOException {
	BufferedReader br = new BufferedReader( new FileReader("fifthwebsiteattempt/testaccess.txt"));
	out.print(br.readLine());
	}
}
