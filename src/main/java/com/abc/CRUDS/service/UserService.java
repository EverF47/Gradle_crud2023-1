package com.abc.CRUDS.service;

import com.abc.CRUDS.model.User;
import com.abc.CRUDS.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class UserService
{
        @Autowired
        private IUserRepository repository;


        public Optional<User> findById(Long id)
        {
            return repository.findById(id);
        }

        public List<User> listAll()
        {
            return repository.findAll();
        }

        public User create(User user)
        {
            return repository.save(user);
        }

        public User update(User user)
        {
            if (user.getId() != null)
            {
                Optional<User> userDb = repository.findById(user.getId());
                if (!userDb.isEmpty())
                {
                    if (user.getNombre() != null)
                    {
                        userDb.get().setNombre(user.getNombre());
                    }
                    if (user.getApellido() != null)
                    {
                        userDb.get().setApellido(user.getApellido());
                    }
                    if (user.getEmail() != null)
                    {
                        userDb.get().setEmail(user.getEmail());
                    }
                    if (user.getEdad() != null)
                    {
                        userDb.get().setEdad(user.getEdad());
                    }
                    if (user.getCumpleaños() != null)
                    {
                        userDb.get().setCumpleaños(user.getCumpleaños());
                    }
                    repository.save(userDb.get());
                    return userDb.get();
                } else
                {
                    return user;
                }
            } else
            {
                return user;
            }
        }
        public boolean delete(Long userId)
        {
            Boolean aBoolean = repository.findById(userId).map(user ->
            {
                repository.delete(user);
                return  true;
            }).orElse(false);
            return aBoolean;
        }
}