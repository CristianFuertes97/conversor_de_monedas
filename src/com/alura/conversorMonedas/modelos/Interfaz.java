package com.alura.conversorMonedas.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfaz {
    Scanner sc = new Scanner(System.in);
    LocalDate fecha = LocalDate.now();
    LocalTime hora = LocalTime.now();
    List<MonedaClass> consultas = new ArrayList<>();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //valores de hora
    int hh = hora.getHour();
    int mm = hora.getMinute();

    public void interaccionUsuario() throws IOException {
        while(true){
            System.out.println("--------BIENVENDIDOS AL CONVERSOR DE MONEDAS-------------");
            System.out.println("""
                    Monedas disponibles:
                    1.Dolar ----> Peso Argentino.
                    2.Peso Argentino -----> Dolar.
                    3.Dolar ------> Real Brasileño.
                    4.Real Brasileño -----> Dolar.
                    5.Dolar -----> Peso Colombiano.
                    6.Peso Colombiano -----> Dolar.
                    7.Consultar Historial.
                    0.Salir
                    """);
            System.out.println("**************************************");
            System.out.println("Ingrese una opcion:");
            int opcion = sc.nextInt();
            if (opcion == 0){
                System.out.println("Finalizando sistema.............");
                break;
            }

            ConsultaAPi consulta = new ConsultaAPi();
            if(opcion == 1) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double monto = sc.nextDouble();
                try {
                    Moneda moneda = consulta.busquedaMoneda("USD", "ARS", monto);
                    MonedaClass conversion = new MonedaClass(moneda, monto, fecha, hh,mm);
                    System.out.println(conversion);
                    consultas.add(conversion);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (opcion == 2) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double monto = sc.nextDouble();
                try {
                    Moneda moneda = consulta.busquedaMoneda("ARS", "USD", monto);
                    MonedaClass conversion = new MonedaClass(moneda, monto,fecha, hh,mm);
                    System.out.println(conversion);
                    consultas.add(conversion);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else if (opcion == 3) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double monto = sc.nextDouble();
                try {
                    Moneda moneda = consulta.busquedaMoneda("USD", "BRL", monto);
                    MonedaClass conversion = new MonedaClass(moneda, monto,fecha, hh,mm);
                    System.out.println(conversion);
                    consultas.add(conversion);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }else if (opcion == 4) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double monto = sc.nextDouble();
                try {
                    Moneda moneda = consulta.busquedaMoneda("BRL", "USD", monto);
                    MonedaClass conversion = new MonedaClass(moneda, monto,fecha, hh,mm);
                    System.out.println(conversion);
                    consultas.add(conversion);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }else if (opcion == 5) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double monto = sc.nextDouble();
                try {
                    Moneda moneda = consulta.busquedaMoneda("USD", "COP", monto);
                    MonedaClass conversion = new MonedaClass(moneda, monto,fecha, hh,mm);
                    System.out.println(conversion);
                    consultas.add(conversion);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }else if (opcion == 6) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double monto = sc.nextDouble();
                try {
                    Moneda moneda = consulta.busquedaMoneda("COP", "USD", monto);
                    MonedaClass conversion = new MonedaClass(moneda, monto,fecha, hh,mm);
                    System.out.println(conversion);
                    consultas.add(conversion);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }else if (opcion == 7){
                System.out.println("-------HISTORIAL DE BUSQUEDA-------------");
                for(MonedaClass item : consultas){
                    System.out.println(item);
                }

            }else {
                System.out.println("Ingrese una opcion valida");
            }

        }
        sc.close();
    }


}
