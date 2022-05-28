package firstProject.function;

import firstProject.Screen.OperationOption;
import firstProject.Screen.Screen;
import firstProject.Screen.frontScreen;

public class ScreenService {

	// static Directory dir = new Directory();

	public static frontScreen frontScreen = new frontScreen();
	public static OperationOption OperationOption = new OperationOption();

	public static Screen CurrentScreen = frontScreen;

	public static Screen getCurrentScreen() {
		return CurrentScreen;
	}

	public static void setCurrentScreen(Screen currentScreen) {
		CurrentScreen = currentScreen;
	}

}
