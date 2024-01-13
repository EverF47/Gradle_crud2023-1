package com.abc.CRUDS.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "Users")
@NoArgsConstructor
@AllArgsConstructor/*anotación de Lombok que se utiliza para generar automáticamente un constructor que acepta todos los campos de la clase como argumentos. Este constructor inicializa todos los campos de la clase con los valores pasados como argumentos.*/
@Data
public class User

    {
        @Id
        private Long id;

        private String nombre;

        private String apellido;

        private String email;

        private Integer edad;

        @JsonFormat(pattern="yyyy-MM-dd")
        public Date cumpleanos;



    }