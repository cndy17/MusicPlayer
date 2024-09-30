import java.util.*;
import java.util.ListIterator;

public class Invoker {
    static private List<Command> invokerCommandList = new ArrayList<Command>();

    static public void addToCommandList(Command c) {
        invokerCommandList.add(c);
    }

    static public void invokeExecute() {
        ListIterator<Command> iter = invokerCommandList.listIterator();
        while (iter.hasNext()) {
            System.out.println();
            iter.next().execute();
        }
        invokerCommandList = new ArrayList<Command>();
    }
    // if you make an exception you do try catch
    /*
    while ( iter.hasNext() ) {

        System.out.println();
        try {
            iter.next().execute();
        } catch(UnableToProtectHarryPotterException e) {
            e.printStackTrace();
        }
    }
    invokerCommandList = new ArrayList<Command>();
*/
}