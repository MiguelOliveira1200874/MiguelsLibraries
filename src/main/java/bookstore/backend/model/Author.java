package bookstore.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid")
    private Long authorId;

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "birthdate")
    private Date birthdate;

    // Default constructor
    public Author() {}

    // Constructor with all fields
    public Author(String name, String bio, Date birthdate) {
        this.name = name;
        this.bio = bio;
        this.birthdate = birthdate;
    }

    // Getters and setters for all fields
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    // Override toString() for easy printing of Author objects
    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    // Other business logic methods can be added here
}