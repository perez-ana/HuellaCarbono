package Vista;

import java.util.Stack;

public class CaretakerCalculo {

    private Stack<MementoCalculo> mementos = new Stack<>();

    // Almacenar un Memento
    public void addMemento(MementoCalculo memento) {
        mementos.push(memento);
    }

    // Recuperar el último Memento almacenado
    public MementoCalculo getMemento() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}
