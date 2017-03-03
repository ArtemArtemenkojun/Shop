package ua.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.entity.Production;

public interface ProductionRepository extends JpaRepository<Production, Integer>{

	@Query("SELECT pr FROM Production pr LEFT JOIN FETCH pr.category LEFT JOIN FETCH pr.description WHERE pr.id = ?1")
	Production findOne(Integer id);
	@Query("SELECT pr FROM Production pr LEFT JOIN FETCH pr.category LEFT JOIN FETCH pr.description")
	List<Production> findAll();
}
