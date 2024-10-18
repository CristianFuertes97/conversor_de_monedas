package com.alura.conversorMonedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPi {
    //Ingresa tu apikey generado de la APi conversor de monedas (ExchangeRate API)
    private String apikey = "e4c7ade799e1d3d3f3fc1d68";

    public Moneda busquedaMoneda(String monedaBase, String monedaConvertir, double monto) throws  InterruptedException{

        String url = "https://v6.exchangerate-api.com/v6/"+apikey+"/pair/"+monedaBase+"/"+monedaConvertir+"/"+monto;

        //solicitud http request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
        //solicitud http response
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

           return (new Gson().fromJson(json, Moneda.class));


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Ocurrio un error la moneda no se encuentra");
        }

        return null;
    }

}
