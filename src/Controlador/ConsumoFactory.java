package Controlador;

import Modelo.Consumo;
import Modelo.ConsumoDAO;

public class ConsumoFactory {
    
    
    
     public static Consumo crearConsumoDesdeBaseDeDatos(int idConsumo) {
        ConsumoDAO consumoDAO = new ConsumoDAO();
        Consumo consumo = consumoDAO.obtenerConsumoPorId(idConsumo);

        if (consumo != null) {
            return consumo; // Si el consumo se obtuvo correctamente, lo devolvemos
        }
        
        return null; // Si no se encuentra el consumo, devolvemos null
    }

    // Método para crear un nuevo objeto Consumo
    public static Consumo crearConsumo(double res, double pollo, double huevos, double leche, double frutasVerduras) {
        Consumo consumo = new Consumo();
        consumo.setRes(res);
        consumo.setPollo(pollo);
        consumo.setHuevos(huevos);
        consumo.setLeche(leche);
        consumo.setFrutasVerduras(frutasVerduras);
        return consumo;
    }
    
    
    
}


