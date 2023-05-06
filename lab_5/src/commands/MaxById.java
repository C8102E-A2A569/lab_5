package commands;

import collection.CollectionManager;
import data.StudyGroup;
import exceptions.InputDataException;
import exceptions.InvalidArgumentException;
import exceptions.WrongCommandException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Implements same-named command
 */
public class MaxById extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public MaxById(CollectionManager collectionManager) {
        super("max_by_id", "Prints object with max ID");
        this.collectionManager = collectionManager;
    }

    /**
     * @param arguments Inline arguments for command
     * @param br BufferedReader to get data for classes
     * @param bw BufferedWriter to write info
     * @return FINISHED, because there's no way to exit from program
     * @throws WrongCommandException
     * @throws InvalidArgumentException
     * @throws IOException
     * @throws InputDataException
     */
    @Override
    public ExitCode apply(String[] arguments, BufferedReader br, BufferedWriter bw) throws WrongCommandException, InvalidArgumentException, IOException, InputDataException {
        if (arguments.length != 0) {
            throw new WrongCommandException(getName(), arguments);
        }
        StudyGroup maxGroup = null;
        for (var sg: collectionManager.getCollection()) {
            if (maxGroup == null || sg.getId() > maxGroup.getId()) {
                maxGroup = sg;
            }
        }
        if (maxGroup == null) {
            System.out.println("Collection is empty!");
        } else {
            System.out.println(maxGroup);
        }

        return ExitCode.FINISHED;
    }
}
