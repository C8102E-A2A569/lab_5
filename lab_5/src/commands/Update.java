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
public class Update extends Command {

    private final CollectionManager collectionManager;

    /**
     * @param collectionManager - Collection to work on
     */
    public Update(CollectionManager collectionManager) {
        super("update", "update id {element}. Updates element at index");
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
            throw new WrongCommandException("update", arguments);
        }

        int id = Integer.parseInt(arguments[0]);
        StudyGroup sg = null;
        for (var entry : collectionManager.getCollection()) {
            if (entry.getId() == id) {
                sg = entry;
                break;
            }
        }
        if (sg == null) {
            throw new InvalidArgumentException(Integer.toString(id), "There's no such ID");
        }

        StudyGroup tmp = new StudyGroup(br, bw, new Date());
        sg.setName(tmp.getName());
        sg.setCoordinates(tmp.getCoordinates());
        sg.setCreationDate(tmp.getCreationDate());
        sg.setStudentsCount(tmp.getStudentsCount());
        sg.setFormOfEducation(tmp.getFormOfEducation());
        sg.setSemesterEnum(tmp.getSemesterEnum());
        sg.setGroupAdmin(tmp.getGroupAdmin());

        return ExitCode.FINISHED;
    }
}
