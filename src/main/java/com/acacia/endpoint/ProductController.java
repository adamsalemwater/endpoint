package com.acacia.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.acacia.models.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
		
    List<Product> productList = new ArrayList<Product>();
    
    ProductController()
	{
		this.initilizeList();
        
	}

	void initilizeList(){
		this.productList.add( new Product(1,"Tooth Paste", 3.50));
		this.productList.add( new Product(2,"Mouthwash", 4.00));
		this.productList.add( new Product(3,"Soap", 2.50));
	}

	// @GetMapping("/product/{id}")
	@RequestMapping(path = "/product{id}", 
        method = RequestMethod.GET)
	public Product getProductById(@PathVariable("id") int inId)
	{
		for (Product product: this.productList) {
			if( product.productId == inId) {
				System.out.println("Get Product => ProductId: " + inId + " returned");
				return product;
			}
		}
		return null;

	}

	@RequestMapping(path = "/product", 
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json")
	public Product addProduct(@RequestBody Product inProduct)
	{
		this.productList.add(inProduct);
		this.printProductList();
		return inProduct;

        // String[] product = inProduct.split(":");
        // this.productList.add( 
		// 		new Product(Integer.parseInt(product[0]), 
		// 					product[1], 
		// 					Double.parseDouble(product[2])));
		// System.out.println("Post Product => ProductId: " + product[0] + " created");
        // return HttpStatus.CREATED;
	}

	@DeleteMapping("/product/{id}")
	public Product  deleteProduct(@PathVariable("id") int inId) {
		Product tobeDeleted = null;
		for(Product product: this.productList){
			if (product.productId == inId){
				tobeDeleted = product;
				this.productList.remove(product);
				break;
			}
		}
		this.printProductList();
		return tobeDeleted;

	}


	void printProductList()
	{
		for (Product product : this.productList) {
			System.out.print("Product Id: " + product.productId + 
			" - Product Name: " + product.productName  + 
			" - Product Price: " + product.productPrice
			);
		}
    }
}

