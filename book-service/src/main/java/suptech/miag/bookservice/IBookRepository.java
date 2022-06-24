package suptech.miag.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IBookRepository extends JpaRepository<BookModel,Long> {
    List<BookModel> findAllById_author();
}
