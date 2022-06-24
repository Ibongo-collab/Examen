package suptech.miag.authorservice.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
