package com.codewithmosh.store.Mapper;

import com.codewithmosh.store.details.ProductDto;
import com.codewithmosh.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId",source = "category.id")
    ProductDto toDto(Product product);

}