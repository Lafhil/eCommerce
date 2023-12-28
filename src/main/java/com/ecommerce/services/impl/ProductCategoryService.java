package com.ecommerce.services.impl;

import com.ecommerce.entities.ProductCategories;
import com.ecommerce.exception.ParentSimilairToShild;
import com.ecommerce.repository.ProductCategoryRepository;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("productCategoryService")
public class ProductCategoryService extends MannageServiceImpl<ProductCategories,Integer, ProductCategoryRepository> {
    @Override
    public ProductCategories saveOne(ProductCategories object) {
        if(!object.isParent() && object.getCategoryId()==object.getCategorieParent().getCategoryId() )
        throw new ParentSimilairToShild("parent and shield are similar");
        else
            return super.saveOne(object);
    }
    public List<ProductCategories> getSubCatgories(){

            ProductCategories categories=new ProductCategories();
            categories.setParent(false);
            Example<ProductCategories> example = Example.of(categories);

        List<ProductCategories> lst=this.getRep().findAll(example);
        lst=lst.stream().filter(cat->cat.getCategorieShilds().isEmpty()).collect(Collectors.toList());
        System.err.println("----------------------"+lst.size());
        return lst;
    }
    public List<ProductCategories> getCategoriesIgnoreCurrent(int current){
        ProductCategories cat1=new ProductCategories();
       // cat.setCategoryId(current);
        Example<ProductCategories> example = Example.of(cat1);
        List<ProductCategories> lst=this.getRep().findAll(example);
       lst=lst.stream().filter(cat->cat.getCategoryId()!=current).collect(Collectors.toList());
        System.err.println("----------------------"+lst.size());
        return lst;
    }
    public ProductCategories getByName(String name){
        ProductCategories cat1=new ProductCategories();
        cat1.setCategoryName(name);
        Example<ProductCategories> example = Example.of(cat1);
        return this.getRep().findAll(example).get(0);
    }
}
