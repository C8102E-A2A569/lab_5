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
public class SumOfStudentsCount extends Command {
    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public SumOfStudentsCount(CollectionManager collectionManager) {
        super("sum_of_students_count", "Sums all students count");
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
        long result = 0;
        for (var sg: collectionManager.getCollection()) {
            result += sg.getStudentsCount();
        }

        System.out.println("Sum of students count: " + result);

        return ExitCode.FINISHED;
    }
}
