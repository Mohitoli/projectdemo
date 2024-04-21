package com.PracticeBoot1.demo10.Service;

import com.PracticeBoot1.demo10.Entity.Entites;
import com.PracticeBoot1.demo10.Exception.UserNotFoundException;
import com.PracticeBoot1.demo10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Servicesimpl implements Services{
    public UserRepository repository;
    public Servicesimpl(UserRepository repository){
        super();
        this.repository=repository;
    }
    @Override
    public Entites Createenitity(Entites entity) {
        return repository.save(entity);
    }

    @Override
    public List<Entites> Getentities() {
        return (List<Entites>) repository.findAll();
    }

    @Override
    public Entites Getempbyid(int id) throws UserNotFoundException {
      Optional<Entites> empentity= repository.findById(id);
     if (!empentity.isPresent()){
         throw new UserNotFoundException("User Not Found");
     }
     return empentity.get();
    }

    @Override
    public Entites Updatebyid(int id, Entites entites) {
        Entites dbentity= repository.findById(id).get();
         if (Objects.nonNull(entites.getName()) &&
        !"".equalsIgnoreCase(entites.getName())){
             dbentity.setName(entites.getName());
        }
        return repository.save(dbentity);
    }

    @Override
    public void  Deletbyid(int id) {
       repository.deleteById(id);

    }

    @Override
    public Entites Getbyname(String name) {
        return repository.getByname(name);
    }
}
