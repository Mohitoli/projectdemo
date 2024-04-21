package com.PracticeBoot1.demo10.Service;

import com.PracticeBoot1.demo10.Entity.Entites;
import com.PracticeBoot1.demo10.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicesTest {
    @Autowired
    public  Services services;
    @Mock
    public UserRepository userRepository;
    @BeforeEach
    void setUp() {
        Entites entites = Entites.builder()
                .name("Mohit")
                .Course("MCA")
                .build();
        Mockito.when(userRepository.getByname("Mohit"))
                .thenReturn(entites);
    }
    @Test
    @DisplayName("GetDataBasedOnValid")
    public void whenvaliddeptname_thendeptsholudfound(){
    String name="Mohit";
        Entites found= services.Getbyname(name);
        assertEquals(name,found.getName());
    }
}