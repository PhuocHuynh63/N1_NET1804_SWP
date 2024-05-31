package com.n3.mebe.service;

import com.n3.mebe.dto.request.product.ProductRequest;
import com.n3.mebe.dto.response.product.ProductResponse;
import com.n3.mebe.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> getListProduct();

    Product getProductById(int id);


    ProductResponse getProductByIdResponse(int id);

    List<Product> getListProductBySubCateName(String cate);

    Product createProduct(ProductRequest productRequest);

    Product updateProduct(int id, ProductRequest productRequest);

    void deleteProduct(int id);

    List<ProductResponse> getListProductByIdOrName(int id, String name);
}
