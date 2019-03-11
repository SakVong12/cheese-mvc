package org.launchcode.controllers.rest;

import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseDTO;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/categories")
public class CategoryRestController {

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping
    public Iterable<Category> getAll() {
        return categoryDao.findAllByOrderByName();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category postNew(@RequestBody Category category) {
        return categoryDao.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        categoryDao.delete(id);
    }

}
