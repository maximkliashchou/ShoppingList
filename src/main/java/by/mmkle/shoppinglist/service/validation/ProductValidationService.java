package by.mmkle.shoppinglist.service.validation;

import by.mmkle.shoppinglist.bean.Product;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductValidationService {
    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
    }

    public void validate(Product product){
        validationRules.forEach(p -> p.validate(product));
    }
}
