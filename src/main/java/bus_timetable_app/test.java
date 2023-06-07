import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    // Perform your desired functionality here
    // ...
    JFrame f = new JFrame();
		f.setSize(400, 400);
		f.getContentPane().setBackground(new Color(0, 100, 0));
		f.setVisible(true);

    // Return a response if needed
    response.getWriter().write("Function called successfully");
  }
}
