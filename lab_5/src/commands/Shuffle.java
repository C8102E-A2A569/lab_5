package commands;

import collection.CollectionManager;
import exceptions.InputDataException;
import exceptions.InvalidArgumentException;
import exceptions.WrongCommandException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;

/**
 * Implements same-named command
 */
public class Shuffle extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public Shuffle(CollectionManager collectionManager) {
        super("shuffle", "Shuffle elements in collection");
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
        if (arguments.length != 0) {
            throw new WrongCommandException("shuffle", arguments);
        }
        Collections.shuffle(collectionManager.getCollection());

        return ExitCode.FINISHED;
    }
}
