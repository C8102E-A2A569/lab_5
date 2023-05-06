package commands;

import collection.CollectionManager;
import data.*;
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
public class Add extends Command {

    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public Add(CollectionManager collectionManager) {
        super("add", "add {element}. Adds new study group to collection");
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
            throw new WrongCommandException("add", arguments);
        }
        collectionManager.getCollection().add(new StudyGroup(br, bw, new Date()));
        return ExitCode.FINISHED;
    }
}
