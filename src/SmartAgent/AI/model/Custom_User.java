package SmartAgent.AI.model;
/**
 * 
 */

/**
 * @author HERVE NG
 *
 */
public class Custom_User implements Comparable<Custom_User>{

	/**
	 * 
	 */

	/**
	 * User Constructor
	 * @param username
	 * @param number choices
	 * @param user ID
	 */
	public Custom_User(String userName, int numChoices, String userID) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.userID = userID;
		this.numChoices = numChoices;
	}
	//instance global variables
	private String userName;
	private int numChoices;
	private String userID;
	

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the numChoices
	 */
	public int getNumChoices() {
		return numChoices;
	}

	/**
	 * @param numChoices the numChoices to set
	 */
	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String QueryUserInfo() {
		String info = "";
		info = "Name: " + userName +"\n" +
			   "Number of Items: " + numChoices +"\n" +
			   "User ID: " + userID +"\n";
		return info;
	}

	@Override
	public int compareTo(Custom_User usr) {
		// TODO Auto-generated method stub
		return this.getUserID().compareTo(usr.getUserID());
	}

}
