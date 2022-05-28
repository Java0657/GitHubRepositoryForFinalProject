package firstProject.storeFile;

import java.io.File;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Repository {
	
// String object
    public static final String store = "src/main/Directory/";
   
	
	private ArrayList<File> files = new ArrayList<>();

	Path path = FileSystems.getDefault().getPath(store).toAbsolutePath();

	File Rfiles = path.toFile();

	public String getName() {
		return store;
	}

	public void print() {
		System.out.println("Existing Files: ");
		files.forEach(f -> System.out.println(f));
	}

	public ArrayList<File> fillFiles() {

		File[] directoryFiles = Rfiles.listFiles();

		files.clear();
		for (File directoryFile : directoryFiles) {
			if (directoryFile.isFile()) {
				files.add(directoryFile);
			}
		}

		Collections.sort(files);

		return files;
	}

	public ArrayList<File> getFiles() {

		fillFiles();
		return files;
	}

}
