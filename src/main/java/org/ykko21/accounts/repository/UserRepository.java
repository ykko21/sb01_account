package org.ykko21.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ykko21.accounts.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //User findUserById(String id);
}
