package com.bugraycl.socialapp.repository;

import com.bugraycl.socialapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
