import java.io.*;
import java.util.*;

/**
 * Morse code converter class
 */
public class MorseCodeConverter {
	// created outside of constructor to prevent errors with static methods
	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * 
	 * @param code
	 * @return string converts to english using fetch
	 */
	public static String convertToEnglish(String code) {
		String english = "";
		while (code.length() > 0) {
			int space = code.indexOf(" ");

			if (space > -1) {
				String temp = code.substring(0, code.indexOf(" "));
				code = code.substring(code.indexOf(" ") + 1);
				if (temp.equals("/")) {
					english += " ";
				} else {
					english += tree.fetch(temp);
				}
			} else {

				if (code.equals("/")) {
					english += " ";
				} else {
					english += tree.fetch(code);
				}

				code = "";
			}
		}
		return english;
	}

	/**
	 * 
	 * @param fileCode
	 * @return string
	 * @throws FileNotFoundException
	 * 
	 *                               uses other method
	 */
	public static String convertToEnglish(File fileCode) throws FileNotFoundException {
		Scanner file = new Scanner(fileCode);
		String english = "";
		String temp = "";
		while (file.hasNext()) {
			temp = file.next();
			english += convertToEnglish(temp);
		}
		return english;
	}

	/**
	 * prints tree
	 * 
	 * @return
	 */

	public static String printTree() {
		String treeStr = "";
		ArrayList<String> arr = tree.toArrayList();

		for (String val : arr) {
			treeStr += val + " ";
		}

		return treeStr.trim();
	}
}
