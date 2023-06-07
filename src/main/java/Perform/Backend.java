package Perform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;

import bus_timetable_app.*;

/**
 * Servlet implementation class Backend
 */
@WebServlet("/Backend")
public class Backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<ArrayList<Bus>> busStops=null;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		PrintWriter out = null;
		response.setContentType("text/html");
		try {
			out = response.getWriter();
		
		
		int indexOfStop=100;//busStops.size(); //this way, if the right stop isn't found, an exception will be raised
		int count=0;
		
//		public static File findFile(HttpServletRequest req) {
			File current_page = new File("e");
			
			//all the parameter names, across all files
			String[] stops = {	"terenureMM", "terenureALDI", "terenureFuneralDirectors", "dameStreet" };
			String[] filenames = { "TerenureMM.html", "TerenureALDI.html", "TerenureFuneralDirectors.html", "dame-street.html" };
			
			
			for (int i=0; i<stops.length; i++) {
				
				String s = stops[i];
				String param = request.getParameter(s);
				
				//out.println("<p>" + stops[i] + "!="+param+" </p>");
				
				try {
					//check if param!=null
					if ( param.equals(s) ) {
						
						String path = getServletContext().getRealPath(filenames[i]);
						current_page = new File(path);
						indexOfStop= getBusStopIndex(stops[i]);
						
						//end loop
						i=stops.length;
					}
				}
				catch (NullPointerException e) {
					
				}
			}
			
			
//		}
		
		
			//System.out.println("index of stop: "+indexOfStop);
	
			out.println("<link rel=stylesheet href=style.css>");
			
			//only want to read all the data once
			if (busStops==null) {
				//now, alter file paths to reflect real file path in system
				ArrayList<ArrayList<Bus>> bus_stops = Bus.createBusObjects();
				
				//this part should be a function but I need servlet context
				
				for (int i=0; i<bus_stops.size(); i++) {
					for (int j=0; j<bus_stops.get(i).size(); j++ ) {
						
						
						
						String badpath = bus_stops.get(i).get(j).filepath;
						
						bus_stops.get(i).get(j).filepath = getServletContext().getRealPath(badpath);
					}
					
				}
				//System.out.println("\n\nbus objects have been created\n\n");
				ViewData call = new ViewData();
				call.addTimetablesToBuses(call, bus_stops);
				
				busStops=bus_stops;
			}
			
			
///
			
			
		//now, all of the paths of the buses are relative to the server network
 
		//get the bus stop specified
			

			
			
			
			
			
			
			
			//out.println("<p>viewData arraylist is working</p>");
			
			
			//current_page = file of page currently on display
			
			
			File file = current_page; //new File (getServletContext().getRealPath("newfile.html"));
			
			//will try to access the file which i tried to place in the same package
			//out.println("<p>about to alter display file with function</p>");
			
			//this doesn't change the file itself, but rather copies the files' contents, and adds info
			//in the main tag
			ArrayList<ViewData> next_buses = bus_timetable_app.mainn.getData(busStops, indexOfStop);
			
			
			alterHtmlFile( file, out, next_buses);
			
			//testwrite(out);
		}
			catch (Exception e){
				out.println("<p>there is an exception</p>");
				e.printStackTrace();
		}
		
		
		
		
	}
	
	
//	public static void testwrite(PrintWriter out) {
//		out.println("<p>you can call other functions with the PW obj as an argument</p>");
//	}
	
	
	public static void alterHtmlFile(File file, PrintWriter out, ArrayList<ViewData> next_buses) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		//if the line doesn't have the <main> tag we are looking to change,
		//just write out exactly what was in the line
		String dupe; //duplicate
		boolean finished=false;
		
		//all html files MUST have a <main> tag for this to work, and the closing </main> MUST be on another line
		while (!finished) {
			
			
			line = br.readLine();
			dupe =line;
			//System.out.println(dupe);
			
			//remove all tabs and spaces from line
			
			try {
				line.replace(" ", "");
				
				//if the line is not <main>
				if ( !(line.equals("<main>")) ) {
					out.println(dupe);
				}
				else {
//					System.out.println("<main> tag found");
					out.println(dupe);
					printBusInformation(next_buses, out);
					finished=true;
				}
			
//				System.out.println(dupe);
			}
			catch (NullPointerException e) {
				System.err.println("line is null");
				finished=true;
			}
			
		}
		
		
		
		while ( (line = br.readLine())!=null) {
			out.println(line);
//			System.out.println(line);
		}
		
		br.close();
	}
	
	
	
	public static void printBusInformation(ArrayList<ViewData> bus_stop, PrintWriter out) {
		//this is almost the toString() method 
		
		for (int i=0; i<bus_stop.size(); i++) {
			ViewData bus = bus_stop.get(i);
			String message="";
			
			out.println("<h2>"+bus.name+"</h2>");
			
			if (bus.timeleft>1) {
				message="<p>&nbsp;The next " +bus.name+" will arrive in "+bus.timeleft +" minutes, at "+bus.time.get(0)+":";
			}
			else if (bus.timeleft==1) {
				message="<p>&nbsp;The next " +bus.name+" will arrive in 1 minute, at "+bus.time.get(0)+":";
			}
			else if (bus.timeleft==0) {
				message="<p>&nbsp;The next " +bus.name+" is scheduled to arrive now, at "+bus.time.get(0)+":";
			}
			
			out.print(message);
			
			
			
			//if it is due at 10:09, we dont want to write " at 10:9 "
			if (bus.time.get(1)>9) {
				out.println(bus.time.get(1) +"</p><br>");
			}
			else {
				out.println("0"+bus.time.get(1) +"</p><br>");
			}
		}
	}
	
	
	
//	0==(TerenureMM);
//	1==(TerenureALDI);
//	2==(TerenureFD);
//	3==(DameStreet);
	
	public static int getBusStopIndex(String s) {
		switch (s) {
		
		case "terenureMM":
			return 0;
		case "terenureALDI":
			return 1;
		case "terenureFuneralDirectors":
			return 2;
		case "dameStreet":
			return 3;
		}
		
		//this way, if a recognised bus stop isn't found, it'll raise an error
		return busStops.size();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
