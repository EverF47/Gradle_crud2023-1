package com.abc.CRUDS.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.Calendar;


@Entity
@Table(name="Users")
public class User
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String nombre;
        private String apellido;
        private String email;
        private Integer edad;
        @JsonFormat(pattern="yyyy-MM-dd")
        private Calendar cumpleaños;

        public User(Long id , String nombre, String apellido, String email, Integer edad, Calendar cumpleaños)
        {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
            this.edad = edad;
            this.cumpleaños = cumpleaños;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getEdad() {
            return edad;
        }

        public void setEdad(Integer edad) {
            this.edad = edad;
        }

        public Calendar getCumpleaños() {
            return cumpleaños;
        }

        public void setCumpleaños(Calendar cumpleaños) {
            this.cumpleaños = cumpleaños;
        }
    }