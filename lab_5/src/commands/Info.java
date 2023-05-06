package commands;

import collection.CollectionManager;
import exceptions.InputDataException;
import exceptions.InvalidArgumentException;
import exceptions.WrongCommandException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Implements same-named command
 */
public class Info extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public Info(CollectionManager collectionManager) {
        super("info", "Prints collection info");
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
    public ExitCode apply(String[] arguments, BufferedReader br, BufferedWriter bw) {
        System.out.println(
                "Collection size: " + collectionManager.getCollection().size() + '\n' +
                        "Initialized: " + collectionManager.getLastInitTime().toString() + '\n' +
                        "Saved: " + (collectionManager.getLastSaveTime() == null ? "not saved yet" : collectionManager.getLastSaveTime()) + '\n'
        );
        return ExitCode.FINISHED;
    }
}
