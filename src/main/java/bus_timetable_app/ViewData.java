package bus_timetable_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ViewData {
	
	public String name;
	//will be used to display the time of the next available bus at this stop
	public ArrayList<Integer> time;
	public int timeleft;
	
	//not sure if location will be necessary
	public String location;
	
	public ViewData (String name, ArrayList<Integer> time, int timeleft) {
		this.name = name;
		this.time = time;
		this.timeleft = timeleft;
	}

	public ViewData () {
	}
	
	public String toString(int hourdue, int minutesdue) {
		return "The next " + this.name + " will arrive in " + 
				this.timeleft + " minutes at " + hourdue + ":"+ minutesdue;
		
	}
	
	
	public void sortData(Bus bus) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(bus.filepath));

		String line;
		String[] words;
		
		//call readline twice to get the important info
		for (int j=0; (line=br.readLine())!=null; j++ ) {
			
			words = (br.readLine()).split("\t");
			//words[0] = end destination, words[1]==time + AM/PM,
			
			
			//determine which timetable to add a new time to
			
			String[] AMorPM = words[1].split(" ");
			String[] time = AMorPM[0].split(":");
			
			int hour = Integer.parseInt(time[0]);
			int minute = Integer.parseInt(time[1]);
			
			//change into 24hr clock
			
			//if it is 12AM, i want 00AM
			if (hour==12)
				hour=0;
			
			//if it is 2:08pm, it will now be 14:08
			if (AMorPM[1].equals("PM"))
				hour+=12;
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(hour);
			temp.add(minute);
			
			
			//add new time to timetable
			bus.timetable.add(temp);
		}
		
		br.close();
		
		
	}
	
	//specific_bus_stop is an index into bus_stops
	
	//finds the next arrival of each bus at this particular spot
	//then will find the next of those to arrive
	public ArrayList<ViewData> findNextBuses(ArrayList<ArrayList<Bus>> bus_stops, int specific_bus_stop) {
		
//		0==(TerenureMM);
//		1==(TerenureALDI);
//		2==(TerenureFD);
//		3==(DameStreet);
		
		ArrayList <ViewData> times = new ArrayList <ViewData>();
		
		LocalDateTime ct = LocalDateTime.now();
		int hour = ct.getHour();
		int min = ct.getMinute();
		
		ArrayList<Bus> busStop = bus_stops.get(specific_bus_stop);
		//busStop = list of buses that stop by this particular stop
		
		//System.out.println(busStop.get(0).location);
		
		for (int j=0; j<busStop.size(); j++ ) {

			
			ArrayList<Integer> results = Bus.findNextArrival(busStop.get(j), hour, min);
			//results = time left, hour, min until bus
			ArrayList<Integer> time = new ArrayList<Integer>();
			time.add(results.get(1));
			time.add(results.get(2));
			
			
			ViewData closestBus = new ViewData(busStop.get(j).name, time, results.get(0));
			//results == time left, hour, minute of bus arrival
			
			times.add(closestBus);
			 
			//System.out.println(closestBus.toString(closestBus.time.get(0), closestBus.time.get(1)));
		}
		
		System.out.println("\n");
		

		return times;
	}
	
	public void addTimetablesToBuses(ViewData obj, ArrayList<ArrayList<Bus>> bus_stops) {
		
		int count=0;
		
		for (int j=0; j<bus_stops.size(); j++ ) {
			for (int i=0; i< bus_stops.get(j).size(); i++) {
				try {
					obj.sortData(bus_stops.get(j).get(i));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					count++;
					System.out.println(count + " " +bus_stops.get(j).get(i).filepath);
				}
			}
		}
	}
	
	
	
}
