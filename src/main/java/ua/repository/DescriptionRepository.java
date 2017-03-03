package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Description;

public interface DescriptionRepository extends JpaRepository<Description, Integer>{

	Description findByColor(String color);

	Description findByMaterial(String material);

	Description findBySize(String size);
	
}
