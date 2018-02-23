import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VagenSearch {

	private File folder;
	private File[] files; // array of files in the folder

	private String[] views = {"CUSTOMER PO NBR"};

	private HashMap<String, HashSet<File>> viewFileMap;

	public VagenSearch() {

		this.folder = new File("D:/Niladri backup/GOAL/ESF Phase 1"); 
		this.files = folder.listFiles();

		// setup empty adjacency list
		viewFileMap = new HashMap<>();
		for (String v : views) {
			viewFileMap.put(v, new HashSet<File>());
		}

		// search all the files
		// int count = 0;
		// System.out.println("processing File :\n");
		for (File f : files) {
			try {
				processFile2(f);
				// System.out.println(count++);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void displayFindings() {

		TreeSet<File> sortedSet;

		System.out.println("\n\nProcessing done, printing op : \n\n");
		StringBuilder str = new StringBuilder("");
		for (String v : views) {
			str.append(v + "\t");
			sortedSet = new TreeSet<>(viewFileMap.get(v));
			str.append(sortedSet.size() + "\t");
			for (File f : sortedSet) {
				str.append(f.getName() + "\t");
			}
			str.append("\n");
		}
		System.out.println(str.toString());
	}

	public void displayFindings_2Cols() {

		TreeSet<File> sortedSet;

		System.out.println("\n\nProcessing done, printing op : \n\n");
		StringBuilder str = new StringBuilder("");
		for (String v : views) {
			sortedSet = new TreeSet<>(viewFileMap.get(v));
			for (File f : sortedSet) {
				str.append(v + "\t" + f.getName() + "\n");
			}
			// str.append("\n");
		}
		System.out.println(str.toString());
	}

	private void catalogFind(File f, String view) {
		viewFileMap.get(view).add(f);
	}

	private void processFile2(final File file) throws IOException {

		String path = file.toString();

		byte[] allStuff = Files.readAllBytes(Paths.get(path));
		String fStr = new String(allStuff).toUpperCase();
		for (String v : views) {

			if (fStr.contains(v))
				catalogFind(file, v);
		}

	}

	public static void main(String[] args) {
		new VagenSearch().displayFindings_2Cols();
	}

}