package com.ecommerce.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface ManageServices <T,ID>{
 T addOne(T object );
     T saveOne(T object);
    void deleteOne(ID key);
     Optional<T> getOne(ID key);
     List<T> getAll();
     boolean existsById(ID key);
}
