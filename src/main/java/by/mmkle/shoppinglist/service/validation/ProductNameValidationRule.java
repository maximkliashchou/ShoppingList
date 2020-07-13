package by.mmkle.shoppinglist.service.validation;

import com.javaguru.shoppinglist.bean.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductNameValidationRule implements ProductValidationRule{
    private Set<String> uniqueNames = new HashSet<>();

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < 3 || product.getName().length() > 32){
            throw new IllegalArgumentException("Name length cant be less than 3 and more than 32");
        }

        if (uniqueNames.contains(product.getName())){
            throw new IllegalArgumentException("Name must be unique");
        }

        uniqueNames.add(product.getName());
    }
}
