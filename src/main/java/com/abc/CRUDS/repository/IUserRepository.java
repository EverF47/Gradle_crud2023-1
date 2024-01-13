package com.abc.CRUDS.repository;

import com.abc.CRUDS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
/*La interface IUserRepository define un repositorio para la entidad User y hereda los métodos básicos de CRUD de la interfaz MongoRepository.
*/


public interface IUserRepository extends MongoRepository<User, Long> {
    public Optional <User> findByEmail(String email);
    public Optional<List<User>> findByCumpleanosBetween(Date from, Date to);

}
