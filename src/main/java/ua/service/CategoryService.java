package ua.service;

import java.util.List;
import ua.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
	
	List<Category>findAll();
	
	void delete (int id);
	
	Category findOne(int id);
	
	void save(Category category);
	
	Page<Category> findAll(Pageable pageable);

	Category findByModel(String model);
	
	Category findByNameCategory(String nameCategory);

}
