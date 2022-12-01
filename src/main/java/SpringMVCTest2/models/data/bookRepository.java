package SpringMVCTest2.models.data;

import SpringMVCTest2.models.book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepository extends CrudRepository<book, Integer> {

}
