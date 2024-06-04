package com.n3.mebe.controller;


import com.n3.mebe.dto.request.product.ProductSkuRequest;
import com.n3.mebe.dto.response.product.ProductSkuResponse;
import com.n3.mebe.entity.Inventory;
import com.n3.mebe.service.iml.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_sku")
public class ProductSkuController {


    @Autowired
    private ProductSkuService productSkuService;


    /**
     *  Request from Client
     *
     */
    @PostMapping("/create/product_id={id}")
    public Inventory createProductSku(@PathVariable("id") int prId, @RequestBody ProductSkuRequest request) {
        return productSkuService.createProductSku(prId, request);
    }

    @PutMapping("/update/productSku_id={id}")
    public Inventory updateProductSku(@PathVariable("id") int prIdSku, @RequestBody ProductSkuRequest request) {
        return productSkuService.updateProductSku(prIdSku, request);
    }

    @DeleteMapping("/delete/productSku_id={id}")
    public void updateProductSku(@PathVariable("id") int prIdSku) {
        productSkuService.deleteProductSku(prIdSku);
    }



    /**
     *  Response from Client
     *
     */

    @GetMapping("/list")
    public List<ProductSkuResponse> getProductSkuList() {
        return productSkuService.getAllProductSku();
    }

}
