package com.mycompany.vehiculomaven;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("SELECT AVG(v.potencia) FROM Vehiculo v WHERE v.tipo = :tipo")
    Double obtenerPotenciaMediaPorTipo(@Param("tipo") String tipo);

    @Query("SELECT MAX(v.potencia) FROM Vehiculo v WHERE v.tipo = :tipo")
    Integer obtenerPotenciaMaximaPorTipo(@Param("tipo") String tipo);
}
