package com.store.web;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.store.entities.Category;
import com.store.entities.Manufacturer;
import com.store.entities.Product;
import com.store.services.CategorySerice;
import com.store.services.ManufacturerService;
import com.store.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategorySerice categoryService;
	@Autowired
	private ManufacturerService manufacturerService;

	private static int currentPage = 1;
	private static int pageSize = 3;

	@RequestMapping("")
	public String index(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		page.ifPresent(p -> currentPage = p);
		size.ifPresent(s -> pageSize = s);

		Pageable pageable = new PageRequest(currentPage - 1, pageSize);
		Page<Product> productPage = productService.getAll(pageable);

		model.addAttribute("productPage", productPage);

		int totalPages = productPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "/products";
	}

	@RequestMapping(value = "/add")
	public String addProduct(@Valid Model model) {
		List<Category> categoryList = categoryService.getAll();
		List<Manufacturer> manufacturerList = manufacturerService.getAll();
		model.addAttribute("product", new Product());
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("manufacturerList", manufacturerList);

		return "addproduct";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Product product) {
//		System.out.println(product);
		productService.save(product);

		return "redirect:/products";
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Product product) {
//		System.out.println(product);
		productService.edit(product);

		return "redirect:/products";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteByID(id);
		return "redirect:/products";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable("id") Integer id, Model model) {
		Product product = productService.getByID(id);
		System.err.println("Product Selected *** "+product);
		model.addAttribute("product", product);

		return "product";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model) {
		Product product = productService.getByID(id);
		List<Category> categoryList = categoryService.getAll();
		List<Manufacturer> manufacturerList = manufacturerService.getAll();

		model.addAttribute("product", product);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("manufacturerList", manufacturerList);

		return "editproduct";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handlerException() {
		return "error/404";
	}

}
