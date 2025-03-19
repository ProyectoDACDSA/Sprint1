package org.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class HotelService {

    // URL base de la API de hoteles
    private static final String API_URL = "https://data.xotelo.com/api";

    // Mapa de claves de API por ciudad
    private static final Map<String, String> apiKeys = new HashMap<>();

    static {
        apiKeys.put("Madrid", "g187514");
        apiKeys.put("Barcelona", "g187497");
        apiKeys.put("Valencia", "g187529");
        apiKeys.put("Granada", "g187441");
        apiKeys.put("Sevilla", "g187443");
        // Agregar más ciudades y sus claves según sea necesario
    }

    // Método para obtener información de hoteles en una ciudad
    public List<Hotel> obtenerHoteles(String ubicacion, String fechaCheckin, String fechaCheckout) {
        // Verificar si la ciudad tiene una clave de API configurada
        String apiKey = apiKeys.get(ubicacion);
        if (apiKey == null) {
            throw new IllegalArgumentException("No se encontró una clave de API para la ciudad: " + ubicacion);
        }

        // Construcción de la URL de la API con los parámetros necesarios
        String url = API_URL + "?location=" + ubicacion + "&checkin_date=" + fechaCheckin + "&checkout_date=" + fechaCheckout;

        // Configuración de los headers para incluir la clave de API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);  // Autenticación con el token de la ciudad correspondiente

        // Realizar la solicitud GET usando RestTemplate y los headers configurados
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Realizamos la solicitud y obtenemos los datos de los hoteles
        ResponseEntity<Hotel[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Hotel[].class);

        // Convertimos el arreglo de hoteles a una lista
        return Arrays.asList(response.getBody());
    }
}
