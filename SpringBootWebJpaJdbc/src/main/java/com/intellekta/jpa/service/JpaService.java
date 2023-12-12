package com.intellekta.jpa.service;

import com.intellekta.jpa.entity.SalesEntity;
import com.intellekta.jpa.repository.JpaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class JpaService {

    private static JpaRepo jpaRepo;

    public JpaService(JpaRepo repo) {
        JpaService.jpaRepo = repo;
    }

    public static Long getCountOfSales() {
        return jpaRepo.count();
    }

    public static SalesEntity getEntityById(long id) {
        Optional<SalesEntity> optEnt = jpaRepo.findById(id);
        if (optEnt.isPresent())
            return optEnt.get();
        else System.out.println("Значения с таким id: " + id + " не существует");
        return null;
    }

    public static void addDataToDb(SalesEntity entity) {
        jpaRepo.save(entity);
    }

    public static List<SalesEntity> getRowsWithPriceMoreThen100() {
        return jpaRepo.findAll().stream().filter(entity -> entity.getPrice() > 100).toList();
    }
}
