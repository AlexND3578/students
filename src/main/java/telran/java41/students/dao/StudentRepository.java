package telran.java41.students.dao;

import java.util.stream.Stream;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.java41.students.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {
	
//	Student save(Student student);
//
//	Optional<Student> findById(int id);
//
//	Optional<Student> deleteById(int id);
//
//	List<Student> findAll();
	
	Stream<Student> findByNameIgnoreCase(String name);

	long countByNameInIgnoreCase(List<String> names);
	
	@Query("{'scores.?0':{'Sgte':?1}}")
	Stream<Student> findByExamAndScoreGreatEqualsThan(String exam, int score);
}
