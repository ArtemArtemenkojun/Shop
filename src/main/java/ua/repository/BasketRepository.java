package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Integer>{
	
//	@Query("SELECT DISTINCT b FROM Basket b LEFT JOIN FETCH b.productions b JOIN FETCH b.persons WHERE r.id=?1")
//	Basket findOne(Integer id);
//	@Query("SELECT DISTINCT b FROM Basket b LEFT JOIN FETCH b.productions b JOIN FETCH b.persons ")
//	List<Basket> findAll();
//	@Query(value="SELECT DISTINCT b FROM Basket b LEFT JOIN FETCH b.productions pr LEFT JOIN FETCH pr.categories  LEFT JOIN FETCH pr.description b JOIN FETCH b.person",
//			countQuery="SELECT count(b.id) FROM Basket b")
//	Page<Basket> findAll(Pageable pageable);
	
}
