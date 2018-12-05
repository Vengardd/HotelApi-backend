package com.spaghettiteam.hotelapi.repository;

import com.spaghettiteam.hotelapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
