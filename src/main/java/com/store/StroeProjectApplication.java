package com.store;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.store.entities.Category;
import com.store.entities.Manufacturer;
import com.store.services.CategorySerice;
import com.store.services.ManufacturerService;

@SpringBootApplication
public class StroeProjectApplication implements CommandLineRunner  {
	@Autowired
     private CategorySerice categorySerice;
	@Autowired
	private ManufacturerService manufacturerService;
	public static void main(String[] args) {
		SpringApplication.run(StroeProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Stream.of("catg1","catg2","catg3").forEach(cat->{
//			categorySerice.save(new Category(null, cat));
//		});
//	}
//		Stream.of("manuf1","manuf2","manuf3").forEach(cat->{
//			manufacturerService.save(new Manufacturer(null, cat));
//		});
	}

}
