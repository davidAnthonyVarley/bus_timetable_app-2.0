package bus_timetable_app;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UI {
	
	public static JFrame createIndex() {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().setBackground(new Color(0, 250, 150));
		
		//how many stops I have in the data
		String[] bus_stops = { "TerenureMM", "TerenureALDI", "TerenureFD", "DameStreet"};

		JButton[] buttons = new JButton[bus_stops.length];
		
//		0==(TerenureMM);
//		1==(TerenureALDI);
//		2==(TerenureFD);
//		3==(DameStreet);
		
		for (int i=0; i< bus_stops.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(bus_stops[i]);
			buttons[i].setBounds(50, i*70, 200, 50);
			buttons[i].setVisible(true);
			buttons[i].setOpaque(false);
			buttons[i].addActionListener(new ActionListener());
			
			f.add(buttons[i]);
		}
		
		
		
		return null;
		
	}
}
