package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByModel(String model);

	Category findByNameCategory(String nameCategory);

}
