package com.richrb97.product1.service;

import com.richrb97.product1.dto.ProductDto;
import com.richrb97.product1.entity.Product;
import com.richrb97.product1.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        return productDtoList;
    }

    public String createProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        productRepository.save(product);
        return "Registrado";
    }
}
