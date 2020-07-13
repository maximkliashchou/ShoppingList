package by.mmkle.shoppinglist.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ShopingCart implements Serializable {
    private String name;
    private List<Product> productList = new ArrayList<>();


    public ShopingCart() {
    }

    public ShopingCart(String name) {
        this.name = name;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopingCart that = (ShopingCart) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productList);
    }

    @Override
    public String toString() {
        return "ShopingCart{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
