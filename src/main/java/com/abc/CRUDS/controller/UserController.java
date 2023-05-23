package com.abc.CRUDS.controller;

import com.abc.CRUDS.model.User;
import com.abc.CRUDS.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Users")
public class UserController
{
    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id)
    {
        return service.findById(id);
    }
    @GetMapping("/all")
    public List<User> listAll()
        {
            return service.listAll();
        }
    @PostMapping
    public User create(@RequestBody User user)
    {
        return service.create(user);
    }

    @PutMapping
    public User update (@RequestBody User user)
    {
        return service.update(user);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id)
    {
        return service.delete(id);
    }

}
