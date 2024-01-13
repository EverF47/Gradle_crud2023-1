package com.abc.CRUDS.service;






import com.abc.CRUDS.model.User;
import com.abc.CRUDS.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private IUserRepository repository;

    public Optional<User> findByEmail (String email){
        return repository.findByEmail(email);
    }

    public Optional<List<User>> findByCumpleanos (Date from, Date to){
        return repository.findByCumpleanosBetween(from, to);
    }

    public Optional<User> findById (Long id){
        return repository.findById(id);
    }

    public List<User> listAll() {
        return repository.findAll();
    }


    public User create(User user) {
        return repository.save(user);
    }


    public User update(User user) {
        //Comprobar que el id no sea nulo, ya que si es nulo no se sabria que usuario actualizar
        if (user.getId() != null) {
            Optional<User> userDb = repository.findById(user.getId()); //Traer el usuario de la base de datos
            if (!userDb.isEmpty()) { //Si encuentra el usuario en la base de datos, entonces
                if (user.getNombre() != null) {
                    userDb.get().setNombre(user.getNombre());//Al usuario de la base de datos se le asigna el nuevo valor
                }
                if (user.getApellido() != null) {
                    userDb.get().setApellido(user.getApellido());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getEdad() != null) {
                    userDb.get().setEdad(user.getEdad());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getCumpleanos() != null) {
                    userDb.get().setCumpleanos(user.getCumpleanos());
                }
                repository.save(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(Long userId) {
        Boolean aBoolean = repository.findById(userId).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

