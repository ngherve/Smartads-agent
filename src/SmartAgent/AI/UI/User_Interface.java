package SmartAgent.AI.UI;
/**
 * 
 */

/**
 * @author HERVE NG
 * Graphical user interface Class for displaying stuff
 *
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import SmartAgent.AI.Utility.Agent_Program;
import SmartAgent.AI.Utility.SinglyLinkedList;
import SmartAgent.AI.Utility.UtilityClass;
import SmartAgent.AI.model.Custom_User;
import SmartAgent.AI.model.Graph;
import SmartAgent.AI.model.ItemAds;

public class User_Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//buttons variables
	private JButton btnGenerateAds;
	private JButton btnEvaluateReward;
	//private JButton btnSelectAd;
	private JButton btnSetNumUsers;
	//private JButton btnAddUser;
	private JButton btndeleteUser;
	private JButton btnDeleteAd;
	private JButton btnCreateAd;
	private JButton btnDisplayAdInfo;
	private JButton btnShowCustomers;
	//private JButton btnPerformanceInsight;
	//private JButton btnRefresh;
	private JButton btnLinkAds;
	private JButton btnUnlinkAds;
	//private JButton btnbestAd;
	private JScrollPane scPane;
	//private JTextArea txtBestAdDisplay;
	private JTextArea txtAreaItemList;
	private SinglyLinkedList<ItemAds> itemsinglList;
	
	//Panels variable
	private JPanel pnlTop;
	//private JPanel pnlButton;
	//private JPanel pnltxt;
	//private JPanel pnlWrapper;
	private JPanel pnlBottom;
	private int count;
	private int numUsers = 0;
	
	private Graph<ItemAds> item;
	private Agent_Program agent_program;
		
	public User_Interface(String title) {
		this.setTitle(title);
		
		agent_program = new Agent_Program(item);
		btnLinkAds = new JButton("Link Similar Item");
		btnUnlinkAds = new JButton("Unlink associated Ads");
		btnGenerateAds = new JButton("Generate Items Ads to Users");
		btnEvaluateReward = new JButton("Evaluate agent reward");
		//btnSelectAd = new  JButton("Select an Ad");
		btnSetNumUsers = new JButton("Set the Number of Users");
		//btnAddUser = new JButton("Add a User");
		btnDisplayAdInfo = new JButton("View Item Insight");
		btnShowCustomers = new JButton("Show Customers");
		//btnPerformanceInsight = new JButton("Performance Insight");
		btnCreateAd = new JButton("Create an Ad");
		
		txtAreaItemList = new JTextArea();
		scPane = new JScrollPane(txtAreaItemList);
		//btnRefresh = new JButton("Refresh");
		btndeleteUser = new JButton("Delete Customer");
		btnDeleteAd = new JButton("Remove an Ad");
		//btnbestAd = new JButton("Display most selected Item");
		//txtBestAdDisplay = new JTextArea();
		
		//Adding to Panel
		
		pnlTop = new JPanel();
		pnlTop.setLayout(new BorderLayout());
		pnlTop.setSize(600, 80);
		pnlTop.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlTop.setBackground(Color.cyan);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText("SmartAdsAgent Simulation Platform");
		lblTitle.setForeground(Color.black);
		pnlTop.add(lblTitle, BorderLayout.NORTH);

		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new GridLayout(2,4));
		pnlButton.setBorder(new EmptyBorder(10,10,10,10));
		pnlButton.add(btnGenerateAds);
		pnlButton.add(btnSetNumUsers);
		//pnlBottom.add(btnAddUser);
		pnlButton.add(btnDisplayAdInfo);
		pnlButton.add(btnShowCustomers);

       	JPanel pnltxt = new JPanel();
		
		pnltxt.setLayout(new GridLayout(1,1));
		txtAreaItemList.setEditable(false);
		txtAreaItemList.setSize(240, 320);
		txtAreaItemList.setMargin(new Insets(10,10,10,10));
		pnltxt.add(scPane);
		pnltxt.setBorder(new EmptyBorder(10,10,0,10));
		
		//Instantiate Wrapper panel.
		JPanel pnlWrapper = new JPanel();
		
		pnlWrapper.setLayout(new BorderLayout());
		
		pnlButton.setSize(20, 640);
		pnlWrapper.add(pnlButton, BorderLayout.NORTH);
		pnlWrapper.add(pnltxt, BorderLayout.CENTER);
		
		pnlBottom = new JPanel();
        
        pnlBottom.setLayout(new GridLayout(3,6));
        pnlBottom.setBorder(new EmptyBorder(10,10,10,10));
		pnlBottom.add(btndeleteUser);
		pnlBottom.add(btnDeleteAd);
		pnlBottom.add(btnCreateAd);
		pnlBottom.add(btnLinkAds);
		pnlBottom.add(btnUnlinkAds);
		pnlBottom.add(btnEvaluateReward);
		
		
		add(pnlTop, BorderLayout.NORTH);
		add(pnlWrapper, BorderLayout.CENTER);
		add(pnlBottom, BorderLayout.SOUTH);
		
		//Action Listeners
		
		//deleting a user
		btndeleteUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String delUser = JOptionPane.showInputDialog("Enter the Name of customer to delete users");
				for(ItemAds c : item.getAllVertices()) {
					c.removeUser(delUser);
				}
			}
		});
		
		btnEvaluateReward.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				agent_program.setItems(item);
				txtAreaItemList.setText("");
				txtAreaItemList.append(agent_program.DetRewardPerAd());
			}
		});
		
		//Initializing the number of users
		btnSetNumUsers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				numUsers = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of custom users"));
			}
		});
		
		//generating and displaying adds
		btnGenerateAds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtAreaItemList.setText("");
				if(item == null) 
					CreateGaph();
				else 
					displayItemsToCusUser();
			}
		});
		
		//adding new Item Ad
		btnCreateAd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				String hCode = "NewItem" + count;
				String name = JOptionPane.showInputDialog(" Item Name");
				String Description = JOptionPane.showInputDialog(" Item Description");
				ItemAds hosp = new ItemAds(name, Description, hCode);
				item.addVertex(hosp);
				JOptionPane.showMessageDialog(null, hosp.getAdName()+"("+hosp.getIdValue()+") "
						+ "has been successfully Added!", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
				viewInsight(hCode);
			}
		});	
		
		//removing an Item from the graph
		btnDeleteAd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(item != null) {
					String hCode = JOptionPane.showInputDialog("Enter Item Code");
					ItemAds hos = null;
					for(ItemAds h : item.getAllVertices()) {
						if(h.getIdValue().equals(hCode)) {
							hos = h;
						}
					}
					item.removeVertex(hos);
					JOptionPane.showMessageDialog(null, hos.getAdName()+"("+hos.getIdValue()+") "
							+ "has been successfully removed!", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		//button to view insight
		btnDisplayAdInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(item == null) {
					JOptionPane.showMessageDialog(null, "No Item selected!", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					String hCode = JOptionPane.showInputDialog("Enter Item's CODE");
					System.out.println(hCode);
					viewInsight(hCode);
				}
			}
		});
		
		btnShowCustomers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				for (int u = 1; u <= numUsers; u++) {
					addUser();
				}
			}
		});
		
		//button to remove item links
		btnUnlinkAds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemAds it1 = null;
				ItemAds it2 = null;
				if(item != null) {
					String c1 = JOptionPane.showInputDialog(" 1st Item CODE");
					String c2 = JOptionPane.showInputDialog(" 2nd Item CODE");
					for(ItemAds h : item.getAllVertices()) {
						if(h.getIdValue().equals(c1)) 
							it1 = h;
						else if(h.getIdValue().equals(c2)) 
							it2 = h;
					}
					if(c1.equals(c2)) {
						JOptionPane.showMessageDialog(null, "An Item cannot be uninked from itself!", "Warning", JOptionPane.WARNING_MESSAGE);
					}else {
						removeEdgeItem(it1, it2);
					}	
				}
			}
		});
		
		//button to add link association between ads
		btnLinkAds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemAds it1 = null;
				ItemAds it2 = null;
				if(item != null) {
					String c1 = JOptionPane.showInputDialog(" 1st Item CODE");
					String c2 = JOptionPane.showInputDialog(" 2nd Item CODE");
					for(ItemAds h : item.getAllVertices()) {
						if(h.getIdValue().equals(c1)) 
							it1 = h;
						else if(h.getIdValue().equals(c2)) 
							it2 = h;
					}
					
					if(c1.equals(c2)) {
						JOptionPane.showMessageDialog(null, "An Item cannot be linked with itself!", "Warning", JOptionPane.WARNING_MESSAGE);
					}else {
						addEdgeItem(it1, it2);
					}	
				}
			}
		});
	}

	/**
	 * Displaying Every Item and its Details in the textbox
	 */
	private void displayItemsToCusUser() {
		txtAreaItemList.setText("");
		txtAreaItemList.append("\t List of Item to market advertisements \n\n");
		for(ItemAds a : item.getAllVertices()) {
			
			txtAreaItemList.append("Item Name: " + a.getAdName() + "Code: " + a.getIdValue() + "\n"
			+ "Item Purchase code: " + a.getIdValue() + "\n"
			+ "Number of views: \n");
			txtAreaItemList.append("Customers who viewed/Purchased: \n");
			//Display list on neighbors.
			ArrayList<String> neighbouringUsers = new ArrayList<>();
			for(ItemAds hos : item.getNeighbors(a)) {
				neighbouringUsers.add(hos.toString());
			}
			for(String specHAds : neighbouringUsers) {
				txtAreaItemList.append("\n"+specHAds+"\n");
			}
			txtAreaItemList.append("\n");
			
			txtAreaItemList.append("Linked Item (Similar): ");
			//Display list of partners for a specific country.
			for(ItemAds n : item.getNeighbors(a)) {
				txtAreaItemList.append("\n"+n.getAdName()+"("+n.getIdValue()+")" +"\n");
			}
			txtAreaItemList.append("\n\n");
		}
	}
	
	private String displayItems() {
		String display = " List of Item to market advertisements \n\n";
		for(ItemAds a : item.getAllVertices()) {
			
			display += ("Item Name: " + a.getAdName() + "Code: " + a.getIdValue() + "\n"
			+ "Item Purchase code: " + a.getIdValue() + "\n"
			+ "\n");
			//Display list on neighbors.
			ArrayList<String> neighbouringUsers = new ArrayList<>();
			for(ItemAds hos : item.getNeighbors(a)) {
				neighbouringUsers.add(hos.toString());
			}
			for(String specHAds : neighbouringUsers) {
				display+=("\n"+specHAds+"\n");
			}
			display+=("\n");
		}
		return display;
	}
	
	/**
	 * this method creates the graph Items
	 * 
	 */
	private void CreateGaph() {
		item = new Graph<ItemAds>();
		itemsinglList = new SinglyLinkedList<ItemAds>();
		
		itemsinglList = UtilityClass.readFile("ItemFile.txt");
		
		for(ItemAds i : itemsinglList) {
			item.addVertex(i);
		}
		displayItemsToCusUser();
	}
	
	/**
	 * this method displays detail of a particular Item
	 * @param hCode
	 */
	private void viewInsight(String itemcode) {
		ItemAds targetItem = null;
		for(ItemAds c : item.getAllVertices()) {
			String Code = c.getIdValue();
			if(Code.equals(itemcode)) {
				targetItem = c;
			}
		}
		if(targetItem != null) {
			if(targetItem.getIdValue().equals(itemcode)) {
				txtAreaItemList.setText("");
				txtAreaItemList.append(targetItem.toString());
				txtAreaItemList.append("\n");
				txtAreaItemList.append("Similar Items: ");
				//Display list of partners for a specific country.
				for(ItemAds n : item.getNeighbors(targetItem)) {
					txtAreaItemList.append("\t"+n.getAdName()+"("+n.getAdDescrip()+") \n");
				}
				txtAreaItemList.append("\n");
				txtAreaItemList.append("Potential Items: \n");
				for(ItemAds n : item.getNeighbors(targetItem)) {
					//Display list of potential partners for a specific country(Partners of partner).
					for(ItemAds p : item.getNeighbors(n)) {
						//Exclude current country and its partners.
						if(p.compareTo(targetItem) != 0 ) {
							if(!item.isAdjacent(p, targetItem)) {
								txtAreaItemList.append("\t"+p.getAdName()+"("+p.getAdDescrip()+") \n");
							}
						}
					}
				}
				txtAreaItemList.append("\n\n");
			}else {
				JOptionPane.showMessageDialog(null, itemcode+" was not found.", "Search result", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, itemcode+" was not found.", "Search result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private String viewInsightItemUsr(String itemcode) {
		ItemAds targetItem = null;
		String insight = "";
		for(ItemAds c : item.getAllVertices()) {
			String Code = c.getIdValue();
			if(Code.equals(itemcode)) {
				targetItem = c;
			}
		}
		if(targetItem != null) {
			if(targetItem.getIdValue().equals(itemcode)) {
				insight+=(targetItem.toString());
				insight+=("\n");
				insight+=("Similar Items: ");
				//Display list of partners for a specific country.
				for(ItemAds n : item.getNeighbors(targetItem)) {
					insight+=("\t"+n.getAdName()+"("+n.getAdDescrip()+") \n");
				}
				insight+=("\n");
				insight+=("Potential Items: \n");
				for(ItemAds n : item.getNeighbors(targetItem)) {
					//Display list of potential partners for a specific country(Partners of partner).
					for(ItemAds p : item.getNeighbors(n)) {
						//Exclude current country and its partners.
						if(p.compareTo(targetItem) != 0 ) {
							if(!item.isAdjacent(p, targetItem)) {
								insight+=("\t"+p.getAdName()+"("+p.getAdDescrip()+") \n");
							}
						}
					}
				}
				insight+=("\n\n");
			}else {
				JOptionPane.showMessageDialog(null, itemcode+" was not found.", "Search result", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, itemcode+" was not found.", "Search result", JOptionPane.INFORMATION_MESSAGE);
		}
		return insight;
	}
	
	/*
	 * This method creates a frame for each custom user
	 */
	private void addUser() {
		//Creating frame
		JFrame CusUser_Frame;
		JTextArea txtusrAds = new JTextArea();
		JScrollPane sctxt = new JScrollPane(txtusrAds);
		JLabel lblTitle = new JLabel();
		//setting up the panel
		JPanel pnltxt = new JPanel();
		JPanel pnltop = new JPanel();
		//JPanel pnlbtm = new JPanel();

		JButton btnViewItem = new JButton("Click Here to View Item");
		btnViewItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(item == null) {
					JOptionPane.showMessageDialog(null, "No Item selected!", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					String userName = JOptionPane.showInputDialog("Enter Your Name to View the Item");
					String hCode = JOptionPane.showInputDialog("Enter Item's CODE");
					txtusrAds.setText(viewInsightItemUsr(hCode));
					

					for(ItemAds c : item.getAllVertices()) {
						String Code = c.getIdValue();
						if(Code.equals(hCode)) {
							boolean isuserFound = false;
							for(int i=0; i<c.getAllUsers().size(); i++) {
								if(c.getAllUsers().get(i).getUserName().equals(userName)) {
									c.getAllUsers().get(i).setNumChoices(c.getAllUsers().get(i).getNumChoices()+1);
									isuserFound = true;
								}
							}
							if(isuserFound==false) {
								Custom_User us = new Custom_User(userName, 1, "USER" + userName);
								c.AddUsers(us);
							}
						}
					}
				}
			}
		});
		
		
		lblTitle.setText("Customer Interface: Welcome user, Please select Items to View/purchase");
		lblTitle.setForeground(Color.black);
		pnltop.add(lblTitle, BorderLayout.NORTH);
		
		txtusrAds.setText("");
		txtusrAds.append(displayItems());	
		//pnlbtm.add(btnViewItem, BorderLayout.SOUTH);
		//adding items to the panel
		pnltxt.setLayout(new GridLayout(1,1));
		txtusrAds.setEditable(false);
		txtusrAds.setSize(240, 320);
		txtusrAds.setMargin(new Insets(10,10,10,10));
		pnltxt.add(sctxt);
		pnltxt.setBorder(new EmptyBorder(10,10,0,10));
		CusUser_Frame = new JFrame("Customer Frame");
		CusUser_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CusUser_Frame.add(pnltop, BorderLayout.NORTH);
		CusUser_Frame.add(pnltxt, BorderLayout.CENTER);
		CusUser_Frame.add(btnViewItem, BorderLayout.SOUTH);
		CusUser_Frame.setSize(700, 500);
		CusUser_Frame.setLocationRelativeTo(null);
		
		//Add windowLister to graphView Frame.
		CusUser_Frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Thread() {
					public void run() {
						//Disable btnVisualRep after it has been clicked 
						btnShowCustomers.setEnabled(true);
					}
				}.start();
				
			}
		});
		
		CusUser_Frame.setVisible(true);
		btnShowCustomers.setEnabled(false);
	}
	
	/**
	 * removing the relationship between 2 Item in the graph
	 * @param item1
	 * @param item2
	 */
	private void removeEdgeItem(ItemAds item1, ItemAds item2) {
		int result =JOptionPane.showConfirmDialog(null, "Do you really want to end association between "
					+item1.getAdName()+"\n and "+item2.getAdName()+"?");
		if(result==JOptionPane.YES_OPTION) {
			if(item.isAdjacent(item1, item2)) {
				item.removeEdge(item1, item2);
				JOptionPane.showMessageDialog(null, item1.getAdName()+"("+item1.getIdValue()+") and "+
						item2.getAdName()+"("+item2.getIdValue()+") are no longer linked!", "Confirmation Message",
															JOptionPane.INFORMATION_MESSAGE);
			}
		}		
		displayItemsToCusUser();
	}
	
	/**
	 * Adding a relationship between 2 hospitals in the graph
	 * @param item1
	 * @param item2
	 */
	private void addEdgeItem(ItemAds item1, ItemAds item2) {
		
		if(!item.isAdjacent(item1, item2)) {
			item.addEdge(item1, item2);
			JOptionPane.showMessageDialog(null, item1.getAdName()+"("+item1.getIdValue()+") and "+
					item2.getAdName()+"("+item2.getIdValue()+") are now linked!", "Confirmation Message",
													JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, item1.getAdName()+"("+item1.getIdValue()+") and "+
					item2.getAdName()+"("+item2.getIdValue()+") are already in a partnership!", "Warning Message",
																JOptionPane.WARNING_MESSAGE);
		}
		displayItemsToCusUser();
	}
}
