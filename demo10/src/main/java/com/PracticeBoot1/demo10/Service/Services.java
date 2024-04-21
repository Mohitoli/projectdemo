package com.PracticeBoot1.demo10.Service;

import com.PracticeBoot1.demo10.Entity.Entites;
import com.PracticeBoot1.demo10.Exception.UserNotFoundException;

import java.util.List;

public interface Services {
    public Entites Createenitity(Entites entity);
    public List<Entites> Getentities();
    public Entites Getempbyid(int id) throws UserNotFoundException;
    public Entites Updatebyid(int id,Entites entites);
    public void Deletbyid(int id);
    public Entites Getbyname(String name);
}
