package pl.marcin.ogloszex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.marcin.ogloszex.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT c.name FROM Category c")
	public List<String> getCategoriesNames();

	@Query("SELECT c FROM Category c where c.name = :category")
	public Optional<Category> findbyName(@Param("category") String category);

}
