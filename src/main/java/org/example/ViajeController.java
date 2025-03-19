package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private BlaBlaCarService blablacarService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("/buscar")
    public List<Viaje> buscarViajes(
            @RequestParam String origen,
            @RequestParam String destino,
            @RequestParam String fecha) {

        List<Viaje> viajes = blablacarService.obtenerViajes(origen, destino, fecha);
        return viajes;
    }
}
