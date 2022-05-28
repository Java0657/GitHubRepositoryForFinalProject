package firstProject.Screen;

import java.io.File;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import firstProject.storeFile.Repository;

public class OperationOption implements Screen {

	private Repository repo = new Repository();

	private ArrayList<String> options = new ArrayList<>();
	
 //option for four operation
	
	public OperationOption() {

		options.add("1. Add a File");
		options.add("2. Delete A File");
		options.add("3. Search A File");
		options.add("4. Return to Menu");

	}

	@Override
	public void Show() {
		System.out.println("Operation Options Menu");
		for (String s : options) {
			System.out.println(s);
		}

	}

	@Override
	public void UserInput() {
		int selOption;
		while ((selOption = this.getOption()) != 4) {
			this.NavigateOption(selOption);
		}
	}

	@Override
	public void NavigateOption(int option) {

		switch (option) {
		// Add File
		case 1: 
			this.AddFile();

			this.Show();
			break;
	    // Delete File
		case 2: 
			this.DeleteFile();

			this.Show();
			break;
	   // Search File	
		case 3: 
			this.SearchFile();
			this.Show();
			break;

		default:
			System.out.println("Invalid Option");
			break;

		}

	}
     // Add method
	public void AddFile() {
		System.out.println("Please Enter the Filename:");

		System.out.println("\n");
		
		String fileName = this.getInputString();

		System.out.println("You are adding a file named: " + fileName);

		try {
			Path path = FileSystems.getDefault().getPath(Repository.store + fileName).toAbsolutePath();
			File file = new File(repo.getName() + fileName);

			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
				repo.getFiles().add(file);

			} else {
				System.out.println("This File Already Exits, no need to add another");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
    //Delete Method
	
	public void DeleteFile() {

		System.out.println("Please Enter the Filename:");

		String fileName = this.getInputString();

		System.out.println("You are deleting a file named: " + fileName);

		Path path = FileSystems.getDefault().getPath(Repository.store + fileName).toAbsolutePath();
		File file = path.toFile();
		if (file.delete()) {
			System.out.println("Deleted File: " + file.getName());
			repo.getFiles().remove(file);
		} else {
			System.out.println("Failed to delete file:" + fileName + ", file was not found.");
		}
	}
    // Search Method
	
	public void SearchFile() {

		Boolean found = false;

		System.out.println("Please Enter the Filename:");

		String fileName = this.getInputString();

		System.out.println("You are searching for a file named: " + fileName);

		// ArrayList obtains files

		ArrayList<File> files = repo.getFiles();

		for (File file : files) {
			if (file.getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
		}
		if (!found) {
			System.out.println("File not found");
		}
	}
   // User Input
	
	private String getInputString() {

		Scanner sc = new Scanner(System.in);
		return (sc.nextLine());

	}
 // get Option Method
	
	private int getOption() {
		Scanner sc = new Scanner(System.in);

		int returnOption = 0;
		try {
			returnOption = sc.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid input");
		}
		return returnOption;

	}

}
