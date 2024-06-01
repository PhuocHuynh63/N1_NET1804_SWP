package com.n3.mebe.service.iml;

import com.n3.mebe.dto.request.product.ProductSkuRequest;
import com.n3.mebe.dto.response.product.ProductSkuResponse;
import com.n3.mebe.entity.Product;
import com.n3.mebe.entity.ProductAttribute;
import com.n3.mebe.entity.ProductSkus;
import com.n3.mebe.exception.AppException;
import com.n3.mebe.exception.ErrorCode;
import com.n3.mebe.repository.IProductSkuRepository;
import com.n3.mebe.service.IProductService;
import com.n3.mebe.service.IProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSkuService implements IProductSkuService {


    @Autowired
    private IProductSkuRepository productSkuRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductAttributeService productAttributeService;


    /**
     *  Request from Client
     *
     */

    // <editor-fold default state="collapsed" desc="Create Product Sku">
    @Override
    public ProductSkus createProductSku(int prId, ProductSkuRequest productSkuRequest) {


        Product product = productService.getProductById(prId);
        ProductSkus productSkus = new ProductSkus();

        //Lấy color từ Id color truyền từ request xuống
        ProductAttribute color = productAttributeService.getProductAttributeById(productSkuRequest.getColorAttributeId());
        //Lấy size từ Id size  truyền từ request xuống
        ProductAttribute size = productAttributeService.getProductAttributeById(productSkuRequest.getSizeAttributeId());


        productSkus.setProduct(product);
        productSkus.setSizeAttributeId(color);
        productSkus.setSizeAttributeId(size);
        productSkus.setSku(productSkuRequest.getSku());
        productSkus.setPrice(productSkuRequest.getPrice());
        productSkus.setQuantity(productSkuRequest.getQuantity());

        return productSkuRepository.save(productSkus);
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="Update Product Sku">
    @Override
    public ProductSkus updateProductSku(int prIdSku,ProductSkuRequest productSkuRequest) {


        ProductSkus productSkus = productSkuRepository.findById(prIdSku)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_SKU_NO_EXIST));

        //Lấy color từ Id color truyền từ request xuống
        ProductAttribute color = productAttributeService.getProductAttributeById(productSkuRequest.getColorAttributeId());
        //Lấy size từ Id size  truyền từ request xuống
        ProductAttribute size = productAttributeService.getProductAttributeById(productSkuRequest.getSizeAttributeId());

        productSkus.setSizeAttributeId(color);
        productSkus.setSizeAttributeId(size);
        productSkus.setSku(productSkuRequest.getSku());
        productSkus.setPrice(productSkuRequest.getPrice());
        productSkus.setQuantity(productSkuRequest.getQuantity());

        return productSkuRepository.save(productSkus);
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="Delete Product Sku">
    @Override
    public void deleteProductSku(int id) {
        productSkuRepository.deleteById(id);
    }// </editor-fold>

    /**
     *  Response from Client
     *
     */

    // <editor-fold default state="collapsed" desc="Get All Product Sku">
    @Override
    public List<ProductSkuResponse> getAllProductSku() {
        List<ProductSkus> list = productSkuRepository.findAll();
        List<ProductSkuResponse> productSkuResponseList = new ArrayList<>();

        for (ProductSkus productSku : list) {
            ProductSkuResponse productSkuResponse = new ProductSkuResponse();
            productSkuResponse.setProductSkuId(productSku.getPsId());
            productSkuResponse.setProduct(productSku.getProduct());
            productSkuResponse.setSizeAttributeId(productSku.getSizeAttributeId());
            productSkuResponse.setColorAttributeId(productSku.getColorAttributeId());
            productSkuResponse.setSku(productSku.getSku());
            productSkuResponse.setPrice(productSku.getPrice());
            productSkuResponse.setQuantity(productSku.getQuantity());
            productSkuResponseList.add(productSkuResponse);
        }
        return productSkuResponseList;
    }// </editor-fold>
}
