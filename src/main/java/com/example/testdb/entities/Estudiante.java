package com.example.testdb.entities; // crear la entidad con las configuraciones
//-capa entidades, representan las tablas en la base de datos
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.aspectj.apache.bcel.classfile.Module.Provide;
@Entity     // 2. indicar que es una entidad
@Table(name = "estudiante")  // 3. crear tabla y asignar nombre
public class Estudiante implements Serializable { //1. implementar serializable para transmitir datos
        // crear las variables de la tabla
    @Id // 6. crear ID
    @GeneratedValue(strategy = GenerationType.AUTO) // 7. el ID se genera automaticamente
    private Integer id;

    @Column(name ="Nombre") //8.crear como columnas y guardar nombre
    private String nombre;

    @Column(name ="Apellido")
    private String apellido;

    @Column(name ="Edad")
    private Integer edad;

    @Column(name ="createdAt") //9. recomendado añadirlo creacion para saber cuando se crea
    private Date createdAt;

    @Column(name ="updatedAT") //10. recomendado añadirlo actualizacion para saber cuando se acrualiza
    private Date updatedAt;

    // 5. constructor
    public Estudiante() {   // crear constructor vacio con Source action
        this.createdAt= new Date(); //9.1 constructor para fecha de crear dato
    }

    // 4. metodos getters y setters
    public Integer getId() { //crear get y set de cada variable con Source action
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}
