
package Vista;

import java.util.Stack;

public class ResiduosCommandInvoker {
    private final Stack<ICommandResiduos> commandHistory = new Stack<>();

    public void executeCommand(ICommandResiduos command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            ICommandResiduos command = commandHistory.pop();
            command.undo();
        }
    }
}