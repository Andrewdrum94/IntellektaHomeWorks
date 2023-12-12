package com.intellekta.jpa.service;

import com.intellekta.jpa.entity.SalesEntity;
import com.intellekta.jpa.repository.JpaRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaService {

    private static JpaRepo jpaRepo;

    public JpaService(JpaRepo repo) {
        JpaService.jpaRepo = repo;
    }

    public static Long getCountOfProducts() {
        return jpaRepo.count();
    }

    public static SalesEntity getEntityById(long id) {
        Optional<SalesEntity> optEnt = jpaRepo.findById(id);
        if (optEnt.isPresent())
            return optEnt.get();
        else System.out.println("Значения с таким id: " + id + " не существует");
        return null;
    }
}
