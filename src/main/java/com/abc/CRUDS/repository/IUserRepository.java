package com.abc.CRUDS.repository;

import com.abc.CRUDS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {



}
