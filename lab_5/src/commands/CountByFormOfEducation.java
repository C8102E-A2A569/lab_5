package commands;

import collection.CollectionManager;
import data.EnumParser;
import exceptions.InputDataException;
import exceptions.InvalidArgumentException;
import exceptions.WrongCommandException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Implements same-named command
 */
public class CountByFormOfEducation extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public CountByFormOfEducation(CollectionManager collectionManager) {
        super("count_by_form_of_education", "Counts number of groups with some form of education");
        this.collectionManager = collectionManager;
    }

    /**
     * @param arguments Inline arguments for command
     * @param br        BufferedReader to get data for classes
     * @param bw        BufferedWriter to write info
     * @return FINISHED, because there's no way to exit from program
     * @throws WrongCommandException
     * @throws InvalidArgumentException
     * @throws IOException
     * @throws InputDataException
     */
    @Override
    public ExitCode apply(String[] arguments, BufferedReader br, BufferedWriter bw) throws WrongCommandException, InvalidArgumentException, IOException, InputDataException {
        if (arguments.length != 1) {
            throw new WrongCommandException(getName(), arguments);
        }
        var formOfEducation = EnumParser.textToFormOfEducation.get(arguments[0]);
        int counter = 0;
        for (var sg : collectionManager.getCollection()) {
            if (sg.getFormOfEducation() == formOfEducation) {
                ++counter;
            }
        }

        System.out.println(counter);
        return ExitCode.FINISHED;
    }
}
