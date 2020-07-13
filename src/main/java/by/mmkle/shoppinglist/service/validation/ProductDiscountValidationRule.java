package by.mmkle.shoppinglist.service.validation;

import by.mmkle.shoppinglist.bean.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule{
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount().compareTo(new BigDecimal(100)) > 0){
            throw new IllegalArgumentException("Discount can't be more than 100");
        }

        if (product.getDiscount().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Discount can't be less than 0");
        }

        if (product.getPrice().compareTo(new BigDecimal(20)) < 0
                && product.getDiscount().compareTo(BigDecimal.ZERO) != 0){
            throw new IllegalArgumentException("Discount can't be applied to products with price less than 20$");
        }
    }
}
