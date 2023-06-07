package bus_timetable_app;

import java.util.ArrayList;

public class Bus {
	
	public String name; //the bus number, ie, 64d, 15A, 49
	
	//timetable is a list of arrays with two values: hour and minute
	
	//it will contain all the times a bus number visits a specific stop ,ie,
	//records every time a 15 bus vists stop 1121 in Terenure, not every stop that one specific 15 bus
	//stops at in Dublin
	public ArrayList <ArrayList<Integer> > timetable;
	
	//the location of the bus stop where the bus STARTS in real life, ie, "Terenure MM" (Mitsubishi Motors), or "Dame Street"
	public String location;
	//filepath of data relevant to current object
	public String filepath;

	
	public Bus(String n, ArrayList <ArrayList<Integer> > timetable, String l, String filepath) {
		this.name = n;
		this.timetable = timetable;
		this.location = l;
		this.filepath = filepath;
	}
	
	public static ArrayList <ArrayList<Bus>> createBusObjects() {
		//2nd dimension = lists of bus objects
		//1st d			= the bus stops
		
		//bus objects			= the indivdual buses, and the times they visit this particular stop
		ArrayList <ArrayList<Bus>>stops = new ArrayList <ArrayList<Bus>>();// = new Bus[][][];
		
		//bus stops = Terenure MM, Terenure Aldi, Terenure Funeral Directors, Dame Street
		
		
		//i know, this is a mess
		
		ArrayList<Bus> TerenureMM = new ArrayList<Bus>();
		ArrayList<Bus> TerenureALDI = new ArrayList<Bus>();
		ArrayList<Bus> TerenureFD = new ArrayList<Bus>();
		ArrayList<Bus> DameStreet = new ArrayList<Bus>();
		
		
		Bus Fifteen_ToCityCentre_FromTerenureMM = new Bus("15", new ArrayList <ArrayList<Integer>>(), 
				"Terenure MM", "busData/Terenure_Mitsubishi_Motors/15bus_data_TerenureMM.txt" );
		Bus FifteenA_ToCityCentre_FromTerenureMM = new Bus("15A", new ArrayList <ArrayList<Integer>>(), 
				"Terenure MM", "busData\\Terenure_Mitsubishi_Motors\\15Abus_data_TerenureGardaStation.txt" );
		
		Bus SixtyFive_ToCityCentre_FromTerenureMM = new Bus("65", new ArrayList <ArrayList<Integer>>(), 
				"Terenure MM",  "busData\\Terenure_Mitsubishi_Motors\\65bus_data_TerenureMM.txt" );
		Bus SixtyFiveB_ToCityCentre_FromTerenureMM = new Bus("65B", new ArrayList <ArrayList<Integer>>(), 
				"Terenure MM",  "busData\\Terenure_Mitsubishi_Motors\\65Bbus_data_TerenureMM.txt" );
		//edited this
		Bus FortyNine_ToCityCentre_FromTerenureMM = new Bus("49", new ArrayList <ArrayList<Integer>>(), 
				"Terenure MM",  "busData\\Terenure_Mitsubishi_Motors\\49bus_data_TerenureMM.txt" );
		
		//add to bus stop
		TerenureMM.add(Fifteen_ToCityCentre_FromTerenureMM);
		TerenureMM.add(FifteenA_ToCityCentre_FromTerenureMM);//TerenureMM.add(FifteenB_ToCityCentre_FromTerenureMM);
		TerenureMM.add(SixtyFive_ToCityCentre_FromTerenureMM);
		TerenureMM.add(SixtyFiveB_ToCityCentre_FromTerenureMM);
		TerenureMM.add(FortyNine_ToCityCentre_FromTerenureMM);
		
		//Terenure_ALDI
		
		Bus Fifteen_ToCityCentre_FromTerenureALDI = new Bus("15", new ArrayList <ArrayList<Integer>>(), 
				"Terenure ALDI", "busData\\Terenure_ALDI\\15bus_data_TerenureALDI.txt" );
		Bus FifteenA_ToCityCentre_FromTerenureALDI = new Bus("15A", new ArrayList <ArrayList<Integer>>(), 
				"Terenure ALDI", "busData\\Terenure_ALDI\\15Abus_data_TerenureALDI.txt" );
		Bus SixtyFive_ToCityCentre_FromTerenureALDI = new Bus("65", new ArrayList <ArrayList<Integer>>(), 
				"Terenure ALDI", "busData\\Terenure_ALDI\\65bus_data_TerenureALDI.txt");
		//edited this
		Bus SixtyFiveB_ToCityCentre_FromTerenureALDI = new Bus("65B", new ArrayList <ArrayList<Integer>>(), 
				"Terenure ALDI", "busData\\Terenure_ALDI\\65Bbus_data_TerenureALDI.txt");
		
		TerenureALDI.add(Fifteen_ToCityCentre_FromTerenureALDI);
		TerenureALDI.add(FifteenA_ToCityCentre_FromTerenureALDI);
		TerenureALDI.add(SixtyFive_ToCityCentre_FromTerenureALDI);
		TerenureALDI.add(SixtyFiveB_ToCityCentre_FromTerenureALDI);
		
		
		//edited this
		Bus FortyNine_ToCityCentre_FromTerenureFD = new Bus("49", new ArrayList <ArrayList<Integer>>(), 
				"Terenure Funeral Directors", "busData\\Terenure_Funeral_Directors\\49bus_data_Terenure_Funeral_Directors.txt");
		Bus Sixteen_ToCityCentre_FromTerenureFD = new Bus("16", new ArrayList <ArrayList<Integer>>(), 
				"Terenure Funeral Directors", "busData\\Terenure_Funeral_Directors\\16bus_data_Terenure_Funeral_Directors.txt");
		
		TerenureFD.add(FortyNine_ToCityCentre_FromTerenureFD);
		TerenureFD.add(Sixteen_ToCityCentre_FromTerenureFD);
		
		
		
		Bus Fifteen_ToTerenure_FromDameStreet = new Bus("15", new ArrayList<ArrayList<Integer>>(), 
				"Dame Street", "busData\\Dame_Street\\15bus_data_DS.txt");
		Bus FifteenA_ToTerenure_FromDameStreet = new Bus("15A", new ArrayList <ArrayList<Integer>>(), 
				"Dame Street", "busData\\Dame_Street\\15Abus_data_DS.txt");
		Bus FifteenB_ToTerenure_FromDameStreet = new Bus("15B", new ArrayList <ArrayList<Integer>>(), 
				"Dame Street", "busData\\Dame_Street\\15Bbus_data_DS.txt");
		Bus Sixteen_ToTerenure_FromDameStreet = new Bus("16", new ArrayList <ArrayList<Integer>>(), 
				"Dame Street", "busData\\Dame_Street\\16bus_data_DS.txt");
		
		Bus SixtyFive_ToTerenure_FromDameStreet = new Bus("65", new ArrayList <ArrayList<Integer>>(), 
				"Dame Street", "busData\\Dame_Street\\65bus_data_DS.txt");
		Bus SixtyFiveB_ToTerenure_FromDameStreet = new Bus("65B", new ArrayList <ArrayList<Integer>>(), 
				"Dame Street", "busData\\Dame_Street\\65Bbus_data_DS.txt");
		Bus FortyNine_ToTerenure_FromDameStreet = new Bus("49", new ArrayList <ArrayList<Integer>>(), 
				"Dame Street", "busData\\Dame_Street\\49bus_data_DS.txt");
		
		//add all buses
		DameStreet.add(Fifteen_ToTerenure_FromDameStreet);
		DameStreet.add(FifteenA_ToTerenure_FromDameStreet);
		DameStreet.add(SixtyFive_ToTerenure_FromDameStreet);
		DameStreet.add(SixtyFiveB_ToTerenure_FromDameStreet);
		DameStreet.add(FortyNine_ToTerenure_FromDameStreet);
		DameStreet.add(Sixteen_ToTerenure_FromDameStreet);
		DameStreet.add(FifteenB_ToTerenure_FromDameStreet);
		
		
		//group together stops
		stops.add(TerenureMM);
		stops.add(TerenureALDI);
		stops.add(TerenureFD);
		stops.add(DameStreet);
		
		
		return stops;
	}
	
	//hour and min = current time

	public static ArrayList<Integer> findNextArrival(Bus bus, int hour, int min) {

		
		
		//test
//		hour =23;
//		min=59;
		
		//how many minutes have passed today
		int minutes_into_day = (hour*60) + min;
		int minutes_into_day_of_selected_bus=0;
		
		int j=0; //need j after loop
		boolean noarrivalsleft=false;
		
		ArrayList<Integer> last_stop = bus.timetable.get(bus.timetable.size()-1);
		
		
		if (minutes_into_day > ((last_stop.get(0)*60) + last_stop.get(1)) ) {
			//if we're past the last stop for today, the next stop will be the first in the morning
			//so we want to access 0 index
			
			//j-- will occur, so we need to set j to 1 now to access index 0 later on, instead of 0 now
			j=1;
			noarrivalsleft=true;
		}
		else {
		
			//1440 minutes in a day	
				for (; minutes_into_day>minutes_into_day_of_selected_bus && minutes_into_day_of_selected_bus<1440; j++ ) {			
					minutes_into_day_of_selected_bus = (bus.timetable.get(j).get(0)*60) + bus.timetable.get(j).get(1);
				}
		}
		
		//find the first bus that is after the next bus, then go back one
		j--;
		int timeleft;
		
		if (!noarrivalsleft) {
			timeleft = minutes_into_day - ((bus.timetable.get(j).get(0)*60) + bus.timetable.get(j).get(1) );
		}
		else {
			timeleft =  ((bus.timetable.get(j).get(0)*60) + bus.timetable.get(j).get(1) + (1440-minutes_into_day));
		}
		
		//System.out.println("Next bus time = "+ bus.timetable.get(j).get(0) +":" + bus.timetable.get(j).get(1));
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		results.add(Math.abs(timeleft));
		results.add(bus.timetable.get(j).get(0));
		results.add(bus.timetable.get(j).get(1));
		//return minutes left, hour, minute of bus
		
		return results;
		
	}


	

	
	
	
	
	
	
	
	
	
	
	
}
