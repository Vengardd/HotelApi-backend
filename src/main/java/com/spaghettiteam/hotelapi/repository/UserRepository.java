package com.spaghettiteam.hotelapi.repository;

import com.spaghettiteam.hotelapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
