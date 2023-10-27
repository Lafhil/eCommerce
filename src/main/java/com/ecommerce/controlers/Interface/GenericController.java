package com.ecommerce.controlers.Interface;

import com.ecommerce.services.interfaces.ManageServices;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/{entity}")
public class GenericController<T, ID> {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    @Getter @Setter
    private MannageServiceImpl<T, ID> service;


    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> entity = service.getOne(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.saveOne(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T updatedEntity) {
        if (service.existsById(id)) {
            updatedEntity = service.saveOne(updatedEntity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (service.existsById(id)) {
            service.deleteOne(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
