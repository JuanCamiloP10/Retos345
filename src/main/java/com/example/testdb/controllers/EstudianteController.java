package com.example.testdb.controllers; // crear capa controlador expone los servicios de la API // ofrece las Apis para que el front las consuma
// -esta capa unicamente expone las peticiones al usuario (puente entre front y los casos de uso), maneja post, put, delete, get
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testdb.entities.Estudiante;
import com.example.testdb.services.EstudianteService;

@Service //1 indicar que es un servicio
@RestController //2 funciona por medio de rest
@RequestMapping("/estudiante") //3.  indicar el mapeo (ubicacion del mapeo por el cual se va a acceder)

public class EstudianteController {

    @Autowired // 4. enlazar el estudianteService
    EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {//4.1 crear constructor
        this.estudianteService = estudianteService;
    }
        // 5. crear los mapeos
    @GetMapping // 5.1 obtiene todos
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return new ResponseEntity<List<Estudiante>>(this.estudianteService.getListEstudiantes(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // 5.2 obtiene por ID (ruta)
    public ResponseEntity<Estudiante> getEstudiante(@PathVariable("id") int id){
        return new ResponseEntity<Estudiante>(this.estudianteService.getEstudiante(id), HttpStatus.OK);
    }

    @PostMapping //5.3 crea estudiante
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante){ // por el body llega el estudiante
        return new ResponseEntity<Estudiante>(this.estudianteService.creaEstudiante(estudiante), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")// 5.4 elimina por ID (ruta)
    public ResponseEntity<String> eliminarEstudiante(@PathVariable("id") int id){
        this.estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<String>("Estudiante Eliminado",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")// 5.5 actualiza por ID (ruta)
    public ResponseEntity<String> actualizarEstudiante(@PathVariable("id") int id, @RequestBody Estudiante estudiante){
        this.estudianteService.actualizarEstudiante(id, estudiante);
        return new ResponseEntity<String>("Estudiante Actualizado",HttpStatus.CREATED); 
    }
}
