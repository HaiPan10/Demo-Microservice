package com.example.demoinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoInventoryService {
    public static void main(String[] args) {
		SpringApplication.run(DemoInventoryService.class, args);
	}

	// @Bean
	// public CommandLineRunner loadData(InventoryRepository inventoryRepository){
	// 	return args -> {
	// 		Inventory inventory = new Inventory();
	// 		inventory.setSkuCode("IPhone_13");
	// 		inventory.setQuantity(100);

	// 		Inventory inventory2 = new Inventory();
	// 		inventory2.setSkuCode("IPhone_14");
	// 		inventory2.setQuantity(0);

	// 		inventoryRepository.save(inventory);
	// 		inventoryRepository.save(inventory2);
	// 	};
	// }
}
