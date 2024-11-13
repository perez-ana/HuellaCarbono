package Modelo;

import Vista.TransporteObserver;
import java.util.ArrayList;
import java.util.List;

public class DatosTransporte {
    private int horasTransporte;
    private double kilometrosRecorridos;
    private String medioTransporteFrecuencia;
    private String medioTransporteUso;
    private List<TransporteObserver> observadores = new ArrayList<>();

    // Constructor
    public DatosTransporte(int horasTransporte, double kilometrosRecorridos, String medioTransporteFrecuencia, String medioTransporteUso) {
        this.horasTransporte = horasTransporte;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.medioTransporteFrecuencia = medioTransporteFrecuencia;
        this.medioTransporteUso = medioTransporteUso;
    }


    // Métodos para agregar observadores
    public void agregarObservador(TransporteObserver observador) {
        observadores.add(observador);
    }

    // Notificar a todos los observadores sobre cambios
    public void notificarObservadores() {
        for (TransporteObserver observador : observadores) {
            observador.actualizar(this);
        }
    }

    // Setter que notifica a los observadores al cambiar el valor
    public void setHorasTransporte(int horasTransporte) {
        this.horasTransporte = horasTransporte;
        notificarObservadores();
    }

    public void setKilometrosRecorridos(double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
        notificarObservadores();
    }

    public void setMedioTransporteFrecuencia(String medioTransporteFrecuencia) {
        this.medioTransporteFrecuencia = medioTransporteFrecuencia;
        notificarObservadores();
    }

    public void setMedioTransporteUso(String medioTransporteUso) {
        this.medioTransporteUso = medioTransporteUso;
        notificarObservadores();
    }

    // Getters
    public int getHorasTransporte() {
        return horasTransporte;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public String getMedioTransporteFrecuencia() {
        return medioTransporteFrecuencia;
    }

    public String getMedioTransporteUso() {
        return medioTransporteUso;
    }

    // Método para calcular la huella de carbono en transporte
    public double calcularHuellaCarbono() {
        // Asignar un factor de emisión basado en el tipo de medio de transporte
        double factorCO2PorKm = 0.0;
        
        // Usar el medio de transporte más frecuente o más utilizado para el cálculo
        switch (medioTransporteUso.toLowerCase()) {
            case "auto":
                factorCO2PorKm = 0.21; // kg CO2 por km
                break;
            case "bus":
                factorCO2PorKm = 0.05; // kg CO2 por km
                break;
            case "moto":
                factorCO2PorKm = 0.10; // kg CO2 por km
                break;
            case "bicicleta":
                factorCO2PorKm = 0.0; // Sin emisiones
                break;
            default:
                factorCO2PorKm = 0.1; // Valor promedio si no se especifica
                break;
        }

        // Calcular la huella de carbono total
        double huellaCarbono = kilometrosRecorridos * factorCO2PorKm;

        // Si las horas de transporte son altas, podemos añadir un extra proporcional
        if (horasTransporte > 10) {
            huellaCarbono += 5.0; // Agregar un extra si se superan las 10 horas de transporte semanal
        }

        return huellaCarbono;
    }


}


