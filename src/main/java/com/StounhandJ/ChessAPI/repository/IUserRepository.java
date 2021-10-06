package com.StounhandJ.ChessAPI.repository;

import com.StounhandJ.ChessAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}