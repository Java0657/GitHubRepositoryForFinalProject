package firstProject.function;

import java.io.File;

import firstProject.storeFile.Repository;

public class functionService {

	private static Repository FDirectory = new Repository();

	public static void PrintFiles() {

		FDirectory.fillFiles();

		for (File file : functionService.getFileDirectory().getFiles()) {
			System.out.println(file.getName());
		}
	}

	public static Repository getFileDirectory() {
		return FDirectory;
	}

	public static void setFileDirectory(Repository fileDirectory) {
		functionService.FDirectory = fileDirectory;
	}

}
