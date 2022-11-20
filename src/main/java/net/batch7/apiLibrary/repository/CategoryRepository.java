package net.batch7.apiLibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.batch7.apiLibrary.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findByIsDeleted(boolean deleted);

  Category findByName(String name);
}
