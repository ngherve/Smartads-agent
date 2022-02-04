
import javax.swing.JFrame;

import SmartAgent.AI.UI.User_Interface;


/**
 * Agent program for Online Marketing
 * @author HERVE NG 217092052
 * Main executing module
 * 
 */

public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//setting variables	
		//search and learn selections per user
		//agent.RandomSearch(file);
		
		User_Interface frame = new User_Interface("Online Marketing Platform");
    	frame.setSize(620, 560);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	frame.setVisible(true);
    	frame.setLocationRelativeTo(null);
	}
}
