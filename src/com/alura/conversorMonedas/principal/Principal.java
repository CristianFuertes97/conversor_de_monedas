package com.alura.conversorMonedas.principal;

import com.alura.conversorMonedas.modelos.ConsultaAPi;
import com.alura.conversorMonedas.modelos.Interfaz;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        // implementamos nuestra clase interfaz
        Interfaz interfaz = new Interfaz();
        interfaz.interaccionUsuario();


    }
}
