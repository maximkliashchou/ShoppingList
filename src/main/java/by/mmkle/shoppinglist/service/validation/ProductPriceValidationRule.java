package by.mmkle.shoppinglist.service.validation;

import com.javaguru.shoppinglist.bean.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule{

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price can't be less than 0");
        }
    }
}
