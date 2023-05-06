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
import java.util.Vector;

/**
 * Implements same-named command
 */
public class RemoveGreater extends Command{
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public RemoveGreater(CollectionManager collectionManager) {
        super("remove_greater", "Removes the biggest element");
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
            throw new WrongCommandException("remove_greater", arguments);
        }

        var target = new StudyGroup(br, bw, new Date());
        Vector<StudyGroup> sifted = new Vector<>();
        for (var sg: collectionManager.getCollection()) {
            if (target.compareTo(sg) >= 0) {
                sifted.add(sg);
            }
        }

        collectionManager.setCollection(sifted);
        return ExitCode.FINISHED;
    }
}
