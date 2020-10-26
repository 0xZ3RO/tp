package seedu.duke.bunnylist;

import seedu.duke.bunny.Bunny;
import seedu.duke.exceptions.BunnyIdeaMissingException;
import seedu.duke.exceptions.CommandMissingArgumentsException;
import seedu.duke.exceptions.MissingParamsException;
import seedu.duke.ui.UI;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.constants.Tags.GENRE_TAG;
import static seedu.duke.constants.Tags.IDEA_TAG;
import static seedu.duke.parsers.Parsers.parseSingleCharacterTaggedParamsFromUserInput;

public class BunnyList {
    public static ArrayList<Bunny> bunniesList = new ArrayList<>();

    /**
     * Adds a bunny to the list of bunny ideas.
     * @param userInput user input command
     * @throws CommandMissingArgumentsException The command for the adding a bunny is missing an argument
     * @throws BunnyIdeaMissingException The idea argument of the add bunny command is missing
     */
    public static void addBunny(String userInput) throws CommandMissingArgumentsException, BunnyIdeaMissingException {
        // for returning filter options parsed from the user input
        HashMap<String, String> commandArguments = new HashMap<>();
        String idea;
        String genre = "";

        // parse bunny command into segments
        try {
            parseSingleCharacterTaggedParamsFromUserInput(userInput, commandArguments);
        } catch (MissingParamsException e) {
            throw new CommandMissingArgumentsException();
        }

        // check if there is task type param
        if (commandArguments.containsKey(IDEA_TAG)) {
            idea = commandArguments.get(IDEA_TAG);
        } else {
            throw new BunnyIdeaMissingException();
        }

        assert !commandArguments.containsKey(IDEA_TAG) : "Missing idea argument not handled!";

        if (commandArguments.containsKey(GENRE_TAG)) {
            genre = commandArguments.get(GENRE_TAG);
        }

        // todo: add the character list to bunny in ver 2
        //ArrayList<Character> characters = new ArrayList<>();
        Bunny newBunny = new Bunny(idea.trim(), genre.trim());
        bunniesList.add(newBunny);
        UI.addBunnyMessage(newBunny.getDescription());

    }

    /**
     * Prints a list of all the bunny ideas in the list.
     */
    public static void listBunny() {
        if (bunniesList.size() == 0) {
            UI.bunnyListEmpty();
        } else {
            UI.listBunnyMessage();
            for (int i = 0; i < bunniesList.size(); i++) {
                System.out.println((i + 1) + ".\n" + bunniesList.get(i).getDescription());
            }

            return;
        }

        assert bunniesList.size() == 0 : "Bunny list cannot be empty at this point";
    }

    /**
     * Get the number of bunnies in the list.
     * @return number of bunnies in list
     */
    public static int numBunny() {
        assert bunniesList.size() < 0 : "Bunny list cannot have negative size";

        return bunniesList.size();
    }

}
