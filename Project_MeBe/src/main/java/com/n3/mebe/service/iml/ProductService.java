package com.n3.mebe.service.iml;


import com.n3.mebe.dto.request.product.ProductRequest;
import com.n3.mebe.dto.response.product.ProductResponse;
import com.n3.mebe.entity.Product;
import com.n3.mebe.exception.AppException;
import com.n3.mebe.exception.ErrorCode;
import com.n3.mebe.repository.IProductRespository;
import com.n3.mebe.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRespository iProductRespository;

    /**
     *  Request from Client
     *
     */

    // <editor-fold default state="collapsed" desc="Create Product">
    @Override
    public Product createProduct(ProductRequest productRequest) {
        if (iProductRespository.existsByName(productRequest.getName())){
            throw new AppException(ErrorCode.PRODUCT_NAME_EXIST);
        }
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setImg(productRequest.getImg());
        product.setDescription(productRequest.getDescription());
        product.setSubCategory(productRequest.getSubCategory());
        product.setNumberView(productRequest.getNumberView());
        product.setFlashSale(productRequest.isFlashSale());
        product.setStatus(productRequest.getStatus());
        product.setCreateAt(productRequest.getCreateAt());
        product.setUpdateAt(productRequest.getUpdateAt());
        product.setInventories(productRequest.getInventories());
        product.setReviewsProducts(productRequest.getReviewsProducts());
        product.setOrderDetails(productRequest.getOrderDetails());

        return iProductRespository.save(product);
    }// </editor-fold>

    //  <editor-fold default state="collapsed" desc="Update Product">
    @Override
    public Product updateProduct(int id, ProductRequest productRequest) {
        Product product = iProductRespository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productRequest.getName());
        product.setImg(productRequest.getImg());
        product.setDescription(productRequest.getDescription());
        product.setSubCategory(productRequest.getSubCategory());
        product.setNumberView(productRequest.getNumberView());
        product.setFlashSale(productRequest.isFlashSale());
        product.setStatus(productRequest.getStatus());
        product.setCreateAt(productRequest.getCreateAt());
        product.setUpdateAt(productRequest.getUpdateAt());
        product.setInventories(productRequest.getInventories());
        product.setReviewsProducts(productRequest.getReviewsProducts());
        product.setOrderDetails(productRequest.getOrderDetails());

        return  iProductRespository.save(product);
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="Delete Product">
    @Override
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        String status = "delete";
        product.setStatus(status);
    }// </editor-fold>

    /**
     *  Response to Client
     *
     */

    // <editor-fold default state="collapsed" desc="GetList Product">
    @Override
    public List<Product> getListProduct() {
        return iProductRespository.findAll();
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="GetList Product Id">
    @Override
    public Product getProductById(int id) {
        return iProductRespository.findById(id).orElseThrow( () -> new AppException(ErrorCode.PRODUCT_NO_EXIST));
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="Get Product By Id Response">
    @Override
    public ProductResponse getProductByIdResponse(int id) {
        Product product = getProductById(id);

        ProductResponse productResponse = new ProductResponse();

        productResponse.setName(product.getName());
        productResponse.setImg(product.getImg());
        productResponse.setDescription(product.getDescription());
        productResponse.setSubCategory(product.getSubCategory());
        productResponse.setNumberView(product.getNumberView());
        productResponse.setFlashSale(product.isFlashSale());
        productResponse.setStatus(product.getStatus());
        productResponse.setCreateAt(product.getCreateAt());
        productResponse.setUpdateAt(product.getUpdateAt());

        return productResponse;
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="Get List Product By SubCate Name">
    @Override
    public List<Product> getListProductBySubCateName(String cateName) {
        return iProductRespository.findBySubCategoryCategoryName(cateName);
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="Get List Product Response By SubCate">
    public List<ProductResponse> getProductResponseList(String cate) {
        List<ProductResponse> productResponseList = new ArrayList<>();

        List<Product> productList = getListProductBySubCateName(cate);
        for (Product product : productList) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setName(product.getName());
            productResponse.setImg(product.getImg());
            productResponse.setDescription(product.getDescription());
            productResponse.setSubCategory(product.getSubCategory());
            productResponse.setNumberView(product.getNumberView());
            productResponse.setFlashSale(product.isFlashSale());
            productResponse.setStatus(product.getStatus());
            productResponse.setCreateAt(product.getCreateAt());
            productResponse.setUpdateAt(product.getUpdateAt());
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }// </editor-fold>

    // <editor-fold default state="collapsed" desc="Get List Product By Id Or Name">
    @Override
    public List<ProductResponse> getListProductByIdOrName(int id, String name) {
        List<Product> product = iProductRespository.findByProductIdOrName(id, name);

        if(product == null) {
            throw new AppException(ErrorCode.PRODUCT_NO_EXIST);
        }

        List<ProductResponse> productResponseList = new ArrayList<>();
        for(Product p : product) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setName(p.getName());
            productResponse.setImg(p.getImg());
            productResponse.setDescription(p.getDescription());
            productResponse.setSubCategory(p.getSubCategory());
            productResponse.setNumberView(p.getNumberView());
            productResponse.setFlashSale(p.isFlashSale());
            productResponse.setStatus(p.getStatus());
            productResponse.setCreateAt(p.getCreateAt());
            productResponse.setUpdateAt(p.getUpdateAt());
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }// </editor-fold>


}
