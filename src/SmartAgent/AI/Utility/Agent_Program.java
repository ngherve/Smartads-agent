/**
 * 
 */
package SmartAgent.AI.Utility;

import java.util.ArrayList;

import SmartAgent.AI.model.Custom_User;
import SmartAgent.AI.model.Graph;
import SmartAgent.AI.model.ItemAds;

/**
 * @author HERVE NG
 *
 */
public class Agent_Program {
	
	//variables
	
	private Graph<ItemAds> items;
	private ArrayList<Integer> itemNumViews;
	private ItemAds maxItem;
	private ItemAds leastItem;
	private ArrayList<ItemAds> ItemsList;

	/**
	 * Agent_Program constructor
	 */
	public Agent_Program(Graph<ItemAds> items) {
		// TODO Auto-generated constructor stub
		this.items = items;
		itemNumViews = new ArrayList<>();
		ItemsList = new ArrayList<>();
	}
	/**
	 * @return the items
	 */
	public Graph<ItemAds> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(Graph<ItemAds> items) {
		this.items = items;
	}
	/**
	 * @return the itemNumViews
	 */
	public ArrayList<Integer> getItemNumViews() {
		return itemNumViews;
	}
	/**
	 * @param itemNumViews the itemNumViews to set
	 */
	public void setItemNumViews(ArrayList<Integer> itemNumViews) {
		this.itemNumViews = itemNumViews;
	}
	/**
	 * Evaluating the reward per ads 
	 * 
	 */
	public String DetRewardPerAd() {
		String displ = "Number of Views per Item\n";
		int totalSel = 0;
		int maxcount = 1;
		int leastcount = 1;
		maxItem = null;
		leastItem = null;
		for (ItemAds item : items.getAllVertices()) {
			totalSel = 0;
			
			for(Custom_User usr : item.getAllUsers()) {
				totalSel += usr.getNumChoices();
			}
			displ += item.getAdName() + " : " + totalSel + "\n"; 
			if(totalSel >= maxcount) {
				maxcount = totalSel;
				maxItem = item;
			}
			if(totalSel < leastcount) {
				leastcount = totalSel;
				leastItem = item;
			}
			itemNumViews.add(totalSel);
			ItemsList.add(item);
		}
		
		if(maxItem!=null)
			displ += "\nThe Item with highest views is: " + maxItem.getAdName() + "-" +maxItem.getIdValue();
		if(leastItem!=null)
			displ += "\nThe Item with least views is: " + leastItem.getAdName() + "-" +leastItem.getIdValue();
		return displ;
	}
	
	/**
	 * Return the Item with max views
	 * @return 
	 */
	public ItemAds getMaxItem() {
		return maxItem;
	}
	/**
	 * @return the itemsList
	 */
	public ArrayList<ItemAds> getItemsList() {
		return ItemsList;
	}
	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(ArrayList<ItemAds> itemsList) {
		ItemsList = itemsList;
	}
	/**
	 * @param maxItem the maxItem to set
	 */
	public void setMaxItem(ItemAds maxItem) {
		this.maxItem = maxItem;
	}
	
}
