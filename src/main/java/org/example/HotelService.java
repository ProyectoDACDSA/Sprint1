package org.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@Service
public class HotelService {
    // URL base de la API de hoteles
    private static final String API_URL = "https://api.hotelservice.com/v1/hotels";

    // Clave de API
    private static final String API_KEY = "TU_API_KEY";  // Reemplaza con tu clave real

    public List<Hotel> obtenerHoteles(String ubicacion, String fechaCheckin, String fechaCheckout) {
        // Construcción de la URL de la API con los parámetros necesarios
        String url = API_URL + "?location=" + ubicacion + "&checkin_date=" + fechaCheckin + "&checkout_date=" + fechaCheckout;

        // Configuración de los headers para incluir la clave de API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);  // Autenticación con el token en los headers

        // Realizar la solicitud GET usando RestTemplate y los headers configurados
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Realizamos la solicitud y obtenemos los datos de los hoteles
        ResponseEntity<Hotel[]> response = restTemplate.getForEntity(url, Hotel[].class, entity);

        // Convertimos el arreglo de hoteles a una lista
        return Arrays.asList(response.getBody());
    }
}
