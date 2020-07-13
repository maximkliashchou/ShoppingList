package by.mmkle.shoppinglist.service.validation;


import by.mmkle.shoppinglist.bean.Product;

public interface ProductValidationRule {
    void validate(Product product);

    default void checkNotNull(Product product){
        if (product == null){
            throw new IllegalArgumentException("Product must be not null");
        }
    }
}
