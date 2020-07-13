package by.mmkle.shoppinglist.service;

import by.mmkle.shoppinglist.bean.Product;
import by.mmkle.shoppinglist.repository.ProductRepository;
import by.mmkle.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductValidationService validationService;

    public Long createProduct(Product product){
        validationService.validate(product);
        Product createdProduct = productRepository.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id);
    }
}
