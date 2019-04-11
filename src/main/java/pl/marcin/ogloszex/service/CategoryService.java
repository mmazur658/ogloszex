package pl.marcin.ogloszex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.marcin.ogloszex.entity.Category;
import pl.marcin.ogloszex.entity.Offer;
import pl.marcin.ogloszex.repository.CategoryRepository;
import pl.marcin.ogloszex.repository.OfferRepository;

@Service
public class CategoryService {

	private final long DEFAULT_CATEGORY_ID = 1;

	private CategoryRepository categoryRepository;
	private OfferRepository offerRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository, OfferRepository offerRepository) {
		this.categoryRepository = categoryRepository;
		this.offerRepository = offerRepository;
	}

	public List<String> findAllCategoryNames() {

		List<String> categoriesNames = categoryRepository.getCategoriesNames();

		return categoriesNames;
	}

	public List<Category> findAll() {

		List<Category> categories = categoryRepository.findAll();

		for (Category category : categories)
			category.setOffers(countOffersByCategory(category));
		return categories;
	}

	public boolean save(Category category) {

		if (category.getId() == null && category.getDescription() != null && category.getName() != null) {
			categoryRepository.save(category);
			return true;
		}

		return false;
	}

	public boolean delete(Long id) {

		Optional<Category> optional = categoryRepository.findById(id);
		Category category = null;

		if (optional.isPresent())
			category = optional.get();

		if (category != null) {

			List<Offer> offers = offerRepository.findByCategory(category);
			Category defaultCategory = getDefaultCategory();

			for (Offer offer : offers)
				changeCategory(offer, defaultCategory);

			categoryRepository.deleteById(id);

			return true;
		} else {
			return false;
		}
	}

	public void changeCategory(Offer offer, Category newCategory) {
		offerRepository.updateOfferCategory(offer.getId(), newCategory);

	}

	private Category getDefaultCategory() {
		Optional<Category> defaultCategory = categoryRepository.findById(DEFAULT_CATEGORY_ID);
		return defaultCategory.get();
	}

	private Long countOffersByCategory(Category category) {
		return offerRepository.countByCategory(category);
	}

}
