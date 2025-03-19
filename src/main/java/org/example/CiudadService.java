package org.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;

@Service
public class CiudadService {

    // Los códigos de API para cada ciudad
    private static final String API_KEY_BARCELONA = "API_KEY_BARCELONA";
    private static final String API_KEY_MADRID = "API_KEY_MADRID";
    private static final String API_KEY_SEVILLA = "API_KEY_SEVILLA";
    private static final String API_KEY_VALENCIA = "API_KEY_VALENCIA";
    private static final String API_KEY_GRANADA = "API_KEY_GRANADA";
    // Agrega más claves de API para otras ciudades

    // Método para obtener información de Barcelona
    public String obtenerInformacionBarcelona() {
        return obtenerInformacionDeCiudad("https://api.barcelo.com/cityinfo/barcelona", API_KEY_BARCELONA);
    }

    // Método para obtener información de Madrid
    public String obtenerInformacionMadrid() {
        return obtenerInformacionDeCiudad("https://api.madrid.com/cityinfo/madrid", API_KEY_MADRID);
    }

    // Método para obtener información de Sevilla
    public String obtenerInformacionSevilla() {
        return obtenerInformacionDeCiudad("https://api.sevilla.com/cityinfo/sevilla", API_KEY_SEVILLA);
    }

    // Método para obtener información de Valencia
    public String obtenerInformacionValencia() {
        return obtenerInformacionDeCiudad("https://api.valencia.com/cityinfo/valencia", API_KEY_VALENCIA);
    }

    // Método para obtener información de Granada
    public String obtenerInformacionGranada() {
        return obtenerInformacionDeCiudad("https://api.granada.com/cityinfo/granada", API_KEY_GRANADA);
    }

    // Método genérico para hacer solicitudes a la API de cada ciudad
    private String obtenerInformacionDeCiudad(String url, String apiKey) {
        // Configuración de los headers para incluir la clave de API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);  // Autenticación con el token en los headers

        // Realizar la solicitud GET usando RestTemplate y los headers configurados
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Realizamos la solicitud y obtenemos la respuesta
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();  // Devuelve la respuesta de la API
    }
}
