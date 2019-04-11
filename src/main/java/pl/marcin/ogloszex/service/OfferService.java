package pl.marcin.ogloszex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.marcin.ogloszex.entity.Category;
import pl.marcin.ogloszex.entity.Offer;
import pl.marcin.ogloszex.repository.CategoryRepository;
import pl.marcin.ogloszex.repository.OfferRepository;
import pl.marcin.ogloszex.utils.OfferView;

@Service
public class OfferService {

	private final long DEFAULT_CATEGORY_ID = 1;

	private OfferRepository offerRepository;
	private CategoryRepository categoryRepository;

	@Autowired
	public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository) {
		this.offerRepository = offerRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<Offer> findAll() {
		return offerRepository.findAll();
	}

	public Long countOffers() {
		return offerRepository.count();
	}

	public List<Offer> findByTitle(String title) {
		return offerRepository.findByTitle(title);
	}

	public boolean save(OfferView offerView) {

		if (offerView.getId() == null && offerView.getPrice() != null && offerView.getDescription() != null
				&& offerView.getTitle() != null) {

			Category category = null;
			Optional<Category> optional = categoryRepository.findbyName(offerView.getCategory());
			if (optional.isPresent()) {
				category = optional.get();
			} else {
				optional = categoryRepository.findById(DEFAULT_CATEGORY_ID);
				category = optional.get();
			}

			Offer offer = new Offer(offerView.getTitle(), offerView.getDescription(), offerView.getImgUrl(),
					offerView.getPrice(), category);

			offerRepository.save(offer);
			return true;
		}
		return false;
	}

	public Optional<Offer> getOfferById(Long id) {
		return offerRepository.findById(id);
	}

	public boolean delete(Long id) {

		if (offerRepository.findById(id) != null) {
			offerRepository.deleteById(id);
			return true;
		}

		return false;
	}

}
