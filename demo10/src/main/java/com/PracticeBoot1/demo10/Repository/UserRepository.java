package com.PracticeBoot1.demo10.Repository;

import com.PracticeBoot1.demo10.Entity.Entites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Entites,Integer> {
    public Entites getByname(String name);
}
