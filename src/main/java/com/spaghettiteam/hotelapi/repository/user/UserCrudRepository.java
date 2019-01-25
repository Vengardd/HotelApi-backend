package com.spaghettiteam.hotelapi.repository.user;

import com.spaghettiteam.hotelapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
}
