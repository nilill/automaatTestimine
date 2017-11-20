package implementations.userInput;

import java.util.Scanner;

public class UserInputFromConsole {

    public static String getUserInput(){
        System.out.println("Enter city: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
        }
}
