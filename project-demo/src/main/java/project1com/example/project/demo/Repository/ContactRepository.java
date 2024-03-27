package project1com.example.project.demo.Repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project1com.example.project.demo.Entity.Contact;

import java.util.List;
@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {

    @Query("from Contact as d where d.user.id=:userId")
    public Page<Contact> findContactsByUser(@Param("userId")int userId, Pageable pageable);
}
