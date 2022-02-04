package SmartAgent.AI.model;

import java.util.ArrayList;

public class ItemAds implements Comparable<ItemAds>{
	
	//instance global variables
	private String adName;
	private ArrayList<Custom_User> users;
	/**
	 * @return the adName
	 */
	public String getAdName() {
		return adName;
	}

	/**
	 * @param adName the adName to set
	 */
	public void setAdName(String adName) {
		this.adName = adName;
	}

	/**
	 * @return the adDescrip
	 */
	public String getAdDescrip() {
		return adDescrip;
	}

	/**
	 * @param adDescrip the adDescrip to set
	 */
	public void setAdDescrip(String adDescrip) {
		this.adDescrip = adDescrip;
	}

	/**
	 * @return the idValue
	 */
	public String getIdValue() {
		return idValue;
	}

	/**
	 * @param idValue the idValue to set
	 */
	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	private String adDescrip;
	private String idValue;
	
	/*
	 * Construction
	 */
	/**
	 * Constructor
	 * @param adName
	 * @param adDescip
	 * @param idValue
	 */
	public ItemAds(String adName, String adDescip, String idValue) {
		this.adDescrip = adDescip;
		this.adName = adName;
		this.idValue = idValue;
		users = new ArrayList<>();
	}

	@Override
	public int compareTo(ItemAds item) {
		// TODO Auto-generated method stub
		return this.getIdValue().compareTo(item.getIdValue());
	}
	
	/**
	 * Associating users to items
	 * @param us
	 */
	public void AddUsers(Custom_User us) {
		users.add(us);
	}
	
	/**
	 * Removing a user from the list
	 * @param usrIndex
	 */
	public void RemUsers(int usrIndex) {
		users.remove(usrIndex);
	}
	
	/**
	 * return the list of users associated with the add
	 * @return
	 */
	public ArrayList<Custom_User> getAllUsers() {
		return users;
	}
	
	/**
	 * displaying details
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String strinut = "Item Name: " + getAdName() + "Code: " + getIdValue() + "\n"
		+ "Item Description: " + getAdDescrip() + "\n"
		+ "Users who viewed:\n";
		
		for (Custom_User custom_User : users) {
			strinut += custom_User.getUserName() + "\tNumber of views" + custom_User.getNumChoices() + "\n";
		}
		
		return strinut;
	}
	
	/**
	 * Removing a user from the list
	 * @param name
	 */
	public void removeUser(String name) {
		for (Custom_User us : users) {
			if(us.getUserName().equals(name)) {
				users.remove(us);
			}
		}
	}
}
