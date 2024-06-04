package com.n3.mebe.service;

import com.n3.mebe.dto.request.product.ProductSkuRequest;
import com.n3.mebe.dto.response.product.ProductSkuResponse;
import com.n3.mebe.entity.Inventory;

import java.util.List;

public interface IProductSkuService {

    List<ProductSkuResponse> getAllProductSku();

    Inventory createProductSku(int prId, ProductSkuRequest productSkuRequest);

    Inventory updateProductSku(int prIdSku, ProductSkuRequest productSkuRequest);

    void deleteProductSku(int id);
}
