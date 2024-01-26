package bookstore.backend.service;

import bookstore.backend.model.Author;
import bookstore.backend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(updatedAuthor.getName());
                    author.setBio(updatedAuthor.getBio());
                    author.setBirthdate(updatedAuthor.getBirthdate());
                    return authorRepository.save(author);
                })
                .orElseGet(() -> {
                    updatedAuthor.setAuthorId(id);
                    return authorRepository.save(updatedAuthor);
                });
    }

    // Add more methods as required
}
