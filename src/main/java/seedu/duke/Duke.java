package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import seedu.duke.constants.Logos;

import static seedu.duke.database.UserSettingsLoader.loadUserSettings;
import static seedu.duke.ui.UI.*;

public class Duke {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * settings set to defaults
     **/
    private static final int NUMBER_OF_SETTINGS = 1; // currently only, username
    public static String username = "User";
    public static ArrayList<String> savedSettings = new ArrayList<>(NUMBER_OF_SETTINGS);


    /**
     * Main entry-point for the CLIcker application.
     */
    public static void main(String[] args) {
        setUserSettingsArrayList(savedSettings, username);
        loadUserSettings(savedSettings);
        printDivider();
        username = savedSettings.get(0);

        System.out.println("Take a quiz with\n" + Logos.DOTTED_CLICKER_LOGO);
        printHelloMessage(username);
        printFarewellMessage(username);

    }

    private static void setUserSettingsArrayList(ArrayList<String> savedSettings, String username) {
        savedSettings.add(username);
    }
}
