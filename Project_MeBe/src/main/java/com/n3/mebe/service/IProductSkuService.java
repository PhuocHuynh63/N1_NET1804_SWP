package com.n3.mebe.service;

import com.n3.mebe.dto.request.product.ProductSkuRequest;
import com.n3.mebe.dto.response.product.ProductSkuResponse;
import com.n3.mebe.entity.ProductSkus;

import java.util.List;

public interface IProductSkuService {

    List<ProductSkuResponse> getAllProductSku();

    ProductSkus createProductSku(int prId, ProductSkuRequest productSkuRequest);

    ProductSkus updateProductSku(int prIdSku, ProductSkuRequest productSkuRequest);

    void deleteProductSku(int id);
}
