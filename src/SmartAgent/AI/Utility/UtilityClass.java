/**
 * 
 */
package SmartAgent.AI.Utility;

import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import SmartAgent.AI.model.ItemAds;


/**
 * @author HERVE NG
 * Utility Class for Reading file
 *
 */
public class UtilityClass {

	/**
	 * 
	 */
	public UtilityClass() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Read value of an index in the file
	 * @param FileName
	 * @param number of row
	 * @param number of column
	 * @return reward
	 */
	public static int readValue(ArrayList<String> fileData, int row, int col) {
		int reward = 0;
		String rowvalue = fileData.get(row);
		String[] data = rowvalue.split(",");

		for (int i = 0; i < 10; i++) {
			if(i==col) {
				reward = Integer.parseInt(data[i]);
			}
		}
		return reward;
	}
	
	/**
	 * Read File
	 * @param FileName
	 * @return an ArrayList of the Items
	 */
	public static SinglyLinkedList<ItemAds> readFile(String FileName)
	{
		SinglyLinkedList<ItemAds> itemlist = new SinglyLinkedList<ItemAds>();
		InputStream filestream = FileReader.class.getResourceAsStream("/././././" + FileName);
		if (filestream == null) System.out.println("File not found");
		Scanner sc ;
		try {
			sc = new Scanner(filestream);
			//int counter = 0;
			while(sc.hasNextLine())
			{
				//counter++;
				String newItem = sc.nextLine();
				StringTokenizer myTokens = new StringTokenizer(newItem, "#");
				while(myTokens.hasMoreTokens())
				{
					// Name # Description # Code
					String itemName = myTokens.nextToken();
					String itemDecription = myTokens.nextToken();
					String ItemCode = myTokens.nextToken();
					//String Code = "Selection" + counter;
					ItemAds theitem = new ItemAds(itemName, itemDecription, ItemCode);
					itemlist.insert(theitem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemlist;
	}
}

