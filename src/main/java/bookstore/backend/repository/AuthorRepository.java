package bookstore.backend.repository;

import bookstore.backend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Find authors by name using a LIKE query for partial matches
    @Query("SELECT a FROM Author a WHERE a.name LIKE %:name%")
    List<Author> findByNameContaining(String name);

    // Find authors by a specific birthdate
    @Query("SELECT a FROM Author a WHERE a.birthdate = :birthdate")
    List<Author> findByBirthdate(Date birthdate);

    // Find authors with a biography containing a specific keyword
    @Query("SELECT a FROM Author a WHERE a.bio LIKE %:keyword%")
    List<Author> findByBioContaining(String keyword);


}