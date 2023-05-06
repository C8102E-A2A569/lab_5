import collection.CollectionManager;
import executor.Executor;
import commands.*;


public class Main {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid number of arguments!");
            return;
        }
        try {
            CollectionManager collectionManager = new CollectionManager(args[0]);
            collectionManager.sort();

            if (!collectionManager.validate()) {
                System.out.println("Not valid data in file!");
                return;
            }
            var commandManager = new CommandManager() {{
                addCommand(new Help(this));
                addCommand(new Info(collectionManager));
                addCommand(new Show(collectionManager));
                addCommand(new Add(collectionManager));
                addCommand(new Update(collectionManager));
                addCommand(new RemoveById(collectionManager));
                addCommand(new Clear(collectionManager));
                addCommand(new Save(collectionManager));
                addCommand(new ExecuteScript(this));
                addCommand(new InsertAtIndex(collectionManager));
                addCommand(new Shuffle(collectionManager));
                addCommand(new RemoveGreater(collectionManager));
                addCommand(new SumOfStudentsCount(collectionManager));
                addCommand(new MaxById(collectionManager));
                addCommand(new CountByFormOfEducation(collectionManager));
            }};

            Executor executor = new Executor(commandManager);
            executor.interactiveRun();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}