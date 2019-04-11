package pl.marcin.ogloszex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.marcin.ogloszex.entity.Category;
import pl.marcin.ogloszex.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

	private CategoryService categoryService;

	@Autowired
	public CategoryRestController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/names")
	public List<String> getCatgoriesNames() {
		List<String> categoriesNames = categoryService.findAllCategoryNames();
		return categoriesNames;
	}

	@GetMapping("")
	public List<Category> getAllCategories() {
		List<Category> categories = categoryService.findAll();

		return categories;
	}

	@PostMapping("")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {

		if (categoryService.save(category))
			return ResponseEntity.ok().body(category);
		else
			return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {

		if (categoryService.delete(id))
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.badRequest().build();
	}

}
