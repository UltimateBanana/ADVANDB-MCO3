package driver;

import java.awt.EventQueue;

import view.MainGUI;

public class Driver {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
