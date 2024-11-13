package Controlador;

import Modelo.Consumo;
import Modelo.ConsumoDAO;


public class ControladorFacade {
    
 private ConsumoDAO consumoDAO;

    public ControladorFacade() {
        consumoDAO = new ConsumoDAO();
    }

    

    // Método para obtener un consumo por su id
    public Consumo obtenerConsumo(int idConsumo) {
        return consumoDAO.obtenerConsumoPorId(idConsumo);
    }

    public void guardarDatos(Consumo consumo) {
    // Usa el decorador para extender la funcionalidad
    DatosConsumoDecorator decorador = new DatosConsumoDecorator(consumo);
    consumoDAO.insertarConsumo(decorador);
    System.out.println("Datos guardados en la base de datos.\n" + decorador.obtenerInformacionExtendida());
}

public void modificarConsumo(Consumo consumo) {
    if (consumo.getIdConsumo() == 0) {
        System.out.println("Error: ID de consumo no especificado.");
        return;
    }
    // Usa el decorador para extender la funcionalidad
    DatosConsumoDecorator decorador = new DatosConsumoDecorator(consumo);
    consumoDAO.modificarConsumo(decorador);
    System.out.println("Consumo modificado en la base de datos.\n" + decorador.obtenerInformacionExtendida());
}

    // Método para eliminar un consumo
    public void eliminarConsumo(int idConsumo) {
        consumoDAO.eliminarConsumo(idConsumo);
        System.out.println("Consumo eliminado de la base de datos.");
    }    
    
}


