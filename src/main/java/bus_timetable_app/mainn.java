package bus_timetable_app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;

public class mainn {

	public static void main(String[] args) {	
	}

	public static ArrayList<ViewData>  getData(ArrayList<ArrayList<Bus>> bus_stops, int indexOfStop) {
		//just for calling functions, cf  = callFunction
		
				ViewData cf = new ViewData();
				ArrayList<ViewData> buses = new ArrayList<ViewData>();
				buses = cf.findNextBuses(bus_stops, indexOfStop);

				return buses;
		
	}
	
	
	
	
	
	

}
