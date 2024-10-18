package com.alura.conversorMonedas.modelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class MonedaClass extends Interfaz{
    private String monedaBase;
    private String monedaConvertir;
    private double monto;
    private double resultado;
    private LocalDate fecha;
    private int hora;
    private int min;

    //constructor
    public MonedaClass(Moneda moneda, double monto, LocalDate fecha, int hora,int min) {
        this.monedaBase = moneda.base_code();
        this.resultado = moneda.conversion_result();
        this.monedaConvertir = moneda.target_code();
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.min = min;
    }

    @Override
    public String toString() {
        return "El valor "+ monto+" ["+monedaBase+"]"+" convertidos a la moneda"+" ["+monedaConvertir+"]"
                +" es igual a: "+resultado+" Fecha Consulta: "+fecha+ " Hora Consulta: "+hora+":"+min;
    }
}
