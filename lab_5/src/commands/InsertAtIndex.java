package commands;

import collection.CollectionManager;
import data.StudyGroup;
import exceptions.InputDataException;
import exceptions.InvalidArgumentException;
import exceptions.WrongCommandException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Implements same-named command
 */
public class InsertAtIndex extends Command {

    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public InsertAtIndex(CollectionManager collectionManager) {
        super("insert_at", "insert_at index {element}");
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
        if (arguments.length != 1) {
            throw new WrongCommandException("insert_at", arguments);
        }

        var index = Integer.parseInt(arguments[0]);
        if (index < 0 || index >= collectionManager.getCollection().size()) {
            throw new InputDataException("Index out of a range!");
        }

        collectionManager.getCollection().insertElementAt(new StudyGroup(br, bw, new Date()), index);

        return ExitCode.FINISHED;
    }
}
