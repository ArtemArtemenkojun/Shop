package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category findOne(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void delete(int id) {
		categoryRepository.delete(id);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category findByModel(String model) {
		return categoryRepository.findByModel(model);
	}

	@Override
	public Category findByNameCategory(String nameCategory) {
		return categoryRepository.findByNameCategory(nameCategory);
	}

}
