package pl.marcin.ogloszex.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.marcin.ogloszex.entity.Category;
import pl.marcin.ogloszex.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
	
	@Query("SELECT o FROM Offer o WHERE UPPER(o.title) LIKE UPPER(CONCAT('%', :title, '%'))")
	public List<Offer> findByTitle(@Param("title") String title);
	
	@Query("SELECT count(1) from Offer o where o.category = :category")
	public Long countByCategory(@Param("category") Category category);

	@Query("SELECT o FROM Offer o where o.category = :category")
	public List<Offer> findByCategory(@Param("category") Category category);

	@Transactional
	@Modifying
	@Query("UPDATE Offer o SET o.category = :newCategory WHERE o.id = :id")
	public void updateOfferCategory(@Param("id") Long id, @Param("newCategory") Category newCategory);

}
