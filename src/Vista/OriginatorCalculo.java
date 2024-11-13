package Vista;

public class OriginatorCalculo {

    private double resultadoHuellaGeneral;

    // Método para establecer el estado
    public void setEstado(double resultadoHuellaGeneral) {
        this.resultadoHuellaGeneral = resultadoHuellaGeneral;
    }

    // Crear un Memento con el estado actual
    public MementoCalculo createMemento() {
        return new MementoCalculo(resultadoHuellaGeneral);
    }

    // Restaurar el estado a partir de un Memento
    public void restoreMemento(MementoCalculo memento) {
        this.resultadoHuellaGeneral = memento.getResultadoHuellaGeneral();
    }

    // Método para obtener el resultado
    public double getResultadoHuellaGeneral() {
        return resultadoHuellaGeneral;
    }
}
