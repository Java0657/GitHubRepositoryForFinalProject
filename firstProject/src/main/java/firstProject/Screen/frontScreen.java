package firstProject.Screen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import firstProject.function.ScreenService;
import firstProject.function.functionService;

public class frontScreen implements Screen {
  
	private String WText = "Simplilearn Phase1 Project!";
	private String Dtext = "Developer: rahul kumar";

	private ArrayList<String> menu = new ArrayList<>();

	public frontScreen() {
		menu.add("1. Show Files");
		menu.add("2. Show File Options Menu");
		menu.add("3. Quit");

	}
// Developer details 
	
	public void DDetail() {
		System.out.println(WText);
		System.out.println(Dtext);
		System.out.println("\n");
		Show();
	}

	@Override
	public void Show() {
		System.out.println("Menu");
		for (String s : menu) {
			System.out.println(s);
		}

	}

	@Override
	public void UserInput() {
		int selectedOption = 0;
		while ((selectedOption = this.getOption()) != 3) {
			this.NavigateOption(selectedOption);
		}
	}

	@Override
	public void NavigateOption(int option) {
		switch (option) {

		case 1: // Show Files in repository
			this.SFiles();

			this.Show();

			break;

		case 2: // Show File frontOperation menu
			
			ScreenService.setCurrentScreen(ScreenService.OperationOption);
			ScreenService.getCurrentScreen().Show();
			ScreenService.getCurrentScreen().UserInput();

			this.Show();

			break;

		default:
			System.out.println("Invalid Option");
			break;
		}

	}

	public void SFiles() {

		System.out.println("List of Files: ");
		functionService.PrintFiles();

	}

	private int getOption() {
		Scanner sc = new Scanner(System.in);

		int returnOption = 0;
		try {
			returnOption = sc.nextInt();
		} catch (InputMismatchException ex) {

		}
		return returnOption;

	}
}
