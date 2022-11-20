package net.batch7.apiLibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.batch7.apiLibrary.model.entity.DetailUser;
import net.batch7.apiLibrary.model.entity.User;

@Repository
public interface DetailUserRepository extends JpaRepository<DetailUser, Long> {
  Optional<DetailUser> findByUser(User user);
}
