// Se crea el archivo java como interface y extends jpa repositorio para hacer las interacciones // capa de acceso a los datos
package com.example.testdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testdb.entities.Estudiante;


@Repository
//HEREDA TODO LO DE REPOSITORIO COMO TIPO ESTUDIANTE
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> { 
    
}
