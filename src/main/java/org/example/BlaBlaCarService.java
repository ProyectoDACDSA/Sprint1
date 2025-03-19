package org.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@Service
public class BlaBlaCarService {
    // URL base de la API de BlaBlaCar
    private static final String API_URL = "https://bus-api.blablacar.com/v3/trips";

    // Clave de API
    private static final String API_KEY = "RPQn87Lb1z2OPQTwsOQsAQ";  // Reemplaza con tu clave real

    public List<Viaje> obtenerViajes(String origen, String destino, String fecha) {
        // Construcción de la URL de la API
        String url = API_URL + "?from=" + origen + "&to=" + destino + "&date=" + fecha;

        // Configuración de los headers para incluir la clave de API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);  // Autenticación con el token en los headers

        // Realizar la solicitud GET usando RestTemplate y los headers configurados
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Realizamos la solicitud y obtenemos los datos
        ResponseEntity<Viaje[]> response = restTemplate.getForEntity(url, Viaje[].class, entity);

        // Convertimos el arreglo de viajes a una lista
        return Arrays.asList(response.getBody());
    }
}
