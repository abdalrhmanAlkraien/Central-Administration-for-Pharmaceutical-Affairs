package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Repostory;

import com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepostory extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);
}
