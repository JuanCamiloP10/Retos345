// Se crea archivo java para hacer los servicios de interaccion(logica de negocios), capa casos de uso
package com.example.testdb.services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testdb.entities.Estudiante;
import com.example.testdb.repositories.EstudianteRepository;

@Service //1 indicar que es un servicio
public class EstudianteService {

    @Autowired //2. enlazar con EstudianteRepository
    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) { // 3. se crea el constructor en source action
        this.estudianteRepository = estudianteRepository;
    }

    //4. metodos CRUD
    public List<Estudiante> getListEstudiantes(){

        return this.estudianteRepository.findAll(); // 4.1 hace el Select * from estudiantes
    }

    public Estudiante getEstudiante(int id){
        if(!this.estudianteRepository.findById(id).isEmpty()){
            return this.estudianteRepository.findById(id).get(); //4.2 hace el Select*from estudiantes con ID=x
        }else {
            return null;
        }
    } 

    public Estudiante creaEstudiante(Estudiante estudiante){ // 4.3 crear y mostrar estudiante
        return this.estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(int id){ // 4.4 crear borrar por ID
        if(!this.estudianteRepository.findById(id).isEmpty()){
            this.estudianteRepository.deleteById(id);
        } 
    }

    public void actualizarEstudiante(int id, Estudiante estudiante){ //4.5 crear actualizar
        if(!this.estudianteRepository.findById(id).isEmpty()){
            Estudiante estudianteDB = this.estudianteRepository.findById(id).get();
                    // validar que no se actualicen los nulos
            if (estudiante.getNombre()!=null){
                estudianteDB.setNombre(estudiante.getNombre());
            }
            if (estudiante.getApellido()!=null){
                estudianteDB.setApellido(estudiante.getApellido());
            }
            if (estudiante.getEdad()!=null){
                estudianteDB.setEdad(estudiante.getEdad());
            }
            estudianteDB.setUpdatedAt(new Date()); // actualiza la fecha
            this.estudianteRepository.save(estudianteDB); // guardar la actualizacion
        } 
    }

    
}
