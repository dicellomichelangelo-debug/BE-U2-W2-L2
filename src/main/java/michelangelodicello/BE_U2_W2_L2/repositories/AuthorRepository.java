package michelangelodicello.BE_U2_W2_L2.repositories;

import michelangelodicello.BE_U2_W2_L2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}