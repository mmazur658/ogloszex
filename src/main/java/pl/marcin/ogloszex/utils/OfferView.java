package pl.marcin.ogloszex.utils;

import java.math.BigDecimal;

public class OfferView {

	private Long id;
	private String title;
	private String description;
	private String imgUrl;
	private BigDecimal price;
	private String category;

	public OfferView() {
	}

	public OfferView(String title, String description, String imgUrl, BigDecimal price, String category) {
		this.title = title;
		this.description = description;
		this.imgUrl = imgUrl;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
