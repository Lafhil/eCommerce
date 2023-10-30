package com.ecommerce.services.interfaces;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public class MannageServiceImpl<T,ID,REPO extends JpaRepository<T,ID>> implements  ManageServices<T,ID>{
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private REPO rep;
    @Override
    public T addOne(T object) {
        return rep.save(object);
    }
    @Override
    public T saveOne(T object) {
        return rep.save(object);
    }

    @Override
    public void deleteOne(ID key) {
        rep.deleteById(key);
    }


    @Override
    public Optional<T> getOne(ID key) {
        return rep.findById(key);
    }

    @Override
    public List<T> getAll() {
        return rep.findAll();
    }

    @Override
    public boolean existsById(ID key) {
        return rep.existsById(key);
    }
}
