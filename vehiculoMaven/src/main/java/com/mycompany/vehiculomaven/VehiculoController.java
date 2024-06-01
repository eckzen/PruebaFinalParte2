package com.mycompany.vehiculomaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable int id) {
        return vehiculoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vehiculo> createVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return ResponseEntity.ok(vehiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable int id) {
        if (vehiculoRepository.existsById(id)) {
            vehiculoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable int id, @RequestBody Vehiculo vehiculo) {
        if (vehiculoRepository.existsById(id)) {
            vehiculo.setId(id);
            Vehiculo updatedVehiculo = vehiculoRepository.save(vehiculo);
            return ResponseEntity.ok(updatedVehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/potencia-media/{tipo}")
    public ResponseEntity<Double> obtenerPotenciaMediaPorTipo(@PathVariable String tipo) {
        Double potenciaMedia = vehiculoRepository.obtenerPotenciaMediaPorTipo(tipo);
        if (potenciaMedia != null) {
            return ResponseEntity.ok(potenciaMedia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/potencia-maxima/{tipo}")
    public ResponseEntity<Integer> obtenerPotenciaMaximaPorTipo(@PathVariable String tipo) {
        Integer potenciaMaxima = vehiculoRepository.obtenerPotenciaMaximaPorTipo(tipo);
        if (potenciaMaxima != null) {
            return ResponseEntity.ok(potenciaMaxima);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
