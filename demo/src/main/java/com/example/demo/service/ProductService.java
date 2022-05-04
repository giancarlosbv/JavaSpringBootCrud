package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    //POST
//  save single item
    public Product saveProduct(Product product){
        return repository.save(product);
    }
//  save items
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
    //GET
//  list all products
    public List<Product> getProducts(){
        return repository.findAll();
    }
//  get product by id
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
//  get product by name
    public Product getProductByName(String name){
        return repository.findByName(name);
    }
//  DELETE
//  delete by id
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed !! " + id;
    }

//  PUT
//  update by ID

    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }






}
