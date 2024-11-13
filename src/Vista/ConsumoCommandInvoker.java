
package Vista;

import java.util.Stack;

public class ConsumoCommandInvoker {
    private final Stack<ICommandConsumo> commandHistory = new Stack<>();
    private final Stack<ICommandConsumo> undoHistory = new Stack<>();

    public void executeCommand(ICommandConsumo command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            ICommandConsumo command = commandHistory.pop();
            command.undo();
            undoHistory.push(command);
        }
    }

    public void redo() {
        if (!undoHistory.isEmpty()) {
            ICommandConsumo command = undoHistory.pop();
            command.execute();
            commandHistory.push(command);
        }
    }
}