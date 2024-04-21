package student.com.example.StudentERP.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import student.com.example.StudentERP.Entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    @Query("select u from Student u where u.email=:email")
    public  Student getUserByUserName(@Param("email")String email);
}
