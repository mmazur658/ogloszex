package pl.marcin.ogloszex.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.marcin.ogloszex.entity.Offer;
import pl.marcin.ogloszex.service.OfferService;
import pl.marcin.ogloszex.utils.OfferView;

@RestController
@RequestMapping("/api/offers")
public class OfferRestController {

	private OfferService offerService;

	@Autowired
	public OfferRestController(OfferService offerService) {
		this.offerService = offerService;
	}

	@GetMapping("")
	public List<OfferView> getAllOffers(@RequestParam(required = false) String title) {

		List<Offer> offers = null;

		if (title != null)
			offers = offerService.findByTitle(title);
		else
			offers = offerService.findAll();

		List<OfferView> offerViews = new ArrayList<>();
		for (Offer offer : offers)
			offerViews.add(createOfferView(offer));

		return offerViews;
	}

	@GetMapping("/count")
	public Long countOffers() {
		Long count = offerService.countOffers();
		return count;
	}

	@PostMapping("")
	public ResponseEntity<OfferView> saveOffer(@RequestBody OfferView offerView) {

		if (offerService.save(offerView))
			return ResponseEntity.ok().body(offerView);
		else
			return ResponseEntity.badRequest().build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<OfferView> getOfferById(@PathVariable Long id) {

		Optional<Offer> optional = offerService.getOfferById(id);

		if (optional.isPresent())
			return ResponseEntity.ok().body(createOfferView(optional.get()));
		else
			return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Offer> deleteService(@PathVariable Long id) {

		if (offerService.delete(id))
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.badRequest().build();
	}

	private OfferView createOfferView(Offer offer) {
		OfferView offerView = new OfferView();
		offerView.setImgUrl(offer.getImgUrl());
		offerView.setCategory(offer.getCategory().getName());
		offerView.setDescription(offer.getDescription());
		offerView.setId(offer.getId());
		offerView.setPrice(offer.getPrice());
		offerView.setTitle(offer.getTitle());
		return offerView;
	}

}
