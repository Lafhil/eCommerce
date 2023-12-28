package com.ecommerce.controlers;

import com.ecommerce.controlers.Interface.GenericController;
import com.ecommerce.entities.ProductCategories;
import com.ecommerce.exception.ParentSimilairToShild;
import com.ecommerce.services.impl.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoriProduct")
public class CategoriProductControler extends GenericController<ProductCategories,Integer,ProductCategoryService> {
   // @Override
    @PostMapping("/withParent")
    public ProductCategories create(@RequestBody List<ProductCategories>  entity ) {

            //String fichier = new String(entity.getCategorieImage(), StandardCharsets.UTF_8);
            ProductCategories parent, shild;
            parent = entity.get(1);
            shild = entity.get(0);
            if (shild.getImageDecode() != null)
                shild.setCategorieImage(shild.getImageDecode().getBytes());
            if (shild.isParent()) {
                shild.setCategorieParent(null);
            }
//        for (ProductCategories cat:entity.getCategorieShilds()
//             ) {
//           // cat.setCategorieImage(cat.getImageDecode().getBytes());
//
//        }
            if (parent != null && !shild.isParent()) {
                if (updateCategorieParent(parent.getCategoryId()) != null) {
                    parent.setCategorieParent(updateCategorieParent(parent.getCategoryId()).get());
                }

                //System.err.println(parent);
                if (parent.getImageDecode() != null)
                    parent.setCategorieImage(parent.getImageDecode().getBytes());

                shild.setCategorieParent(parent);
                System.err.println(shild.getCategoryId() + "ididididid");
                if (shild.getCategoryId() == null) {
                    parent.getCategorieShilds().add(shild);
                    return super.create(parent);
                }
            }
            return super.create(shild);


    }
   @GetMapping("/getParent/{id}")
    public Optional<ProductCategories> updateCategorieParent(@PathVariable int id) {
        try {
            Optional<ProductCategories> parent= Optional.of( super.getService().getOne(id).get().getCategorieParent());
            if(parent.isPresent())
            {
                return parent;
            }else {
                return null;
            }
        }catch (Exception ex){
            return null;
        }


    }
    @GetMapping("/getShilds")
    public ResponseEntity<List<ProductCategories>>getShilds(){
        return ResponseEntity.of(Optional.ofNullable(getService().getSubCatgories()));
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<ProductCategories>getByName(@PathVariable String name){
        return ResponseEntity.of(Optional.ofNullable(getService().getByName(name)));
    }
    @GetMapping("/getCategoriesIgnorCurrent/{current}")
    public List<ProductCategories>getCategoriesIgnoreCurrent(@PathVariable int current){
        System.out.println(current);
        return getService().getCategoriesIgnoreCurrent(current);
    }

}
