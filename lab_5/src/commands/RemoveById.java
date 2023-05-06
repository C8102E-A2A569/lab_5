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
public class RemoveById extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public RemoveById(CollectionManager collectionManager) {
        super("remove_by_id", "remove_by_id id. Removes element with equal id");
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
    public ExitCode apply(String[] arguments, BufferedReader br, BufferedWriter bw) throws WrongCommandException, InvalidArgumentException, IOException {
        if (arguments.length != 1) {
            throw new WrongCommandException("remove_by_id", arguments);
        }
        int id = Integer.parseInt(arguments[0]);
        for (int i = 0; i < collectionManager.getCollection().size(); ++i) {
            if (collectionManager.getCollection().get(i).getId() == id) {
                collectionManager.getCollection().remove(i);
                System.out.println("Removed!");
                return ExitCode.FINISHED;
            }
        }
        System.out.println("There's no such element!");
        return ExitCode.FINISHED;
    }
}
