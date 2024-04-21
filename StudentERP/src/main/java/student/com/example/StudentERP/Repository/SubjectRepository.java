package student.com.example.StudentERP.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import student.com.example.StudentERP.Entity.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Integer> {

    @Query("from Subject as s where s.student.id=:studentId")
    public List<Subject> findSubjectByStudent(@Param("studentId") int studentId );
}
