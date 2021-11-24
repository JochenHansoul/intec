package be.jochenhansoul.petstore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Category category;
    private String name;
    private PetStatus status;
    @ElementCollection
    private List<String> photoUrls;
    @ManyToMany
    @ToString.Exclude
    private Set<Tag> tags;

    public Pet(Long id, Category category, String name, PetStatus status) {
        this(id, category, name, status, new ArrayList<>(), new HashSet<>());
    }

    public Pet(Long id, Category category, String name, PetStatus status, List<String> photoUrls, Set<Tag> tags) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.status = status;
        this.photoUrls = photoUrls;
        this.tags = tags;
    }

    public void addPhoto(String photoUrl) {
        this.photoUrls.add(photoUrl);
    }

    public void removePhoto(String photoUrl) {
        this.photoUrls.remove(photoUrl);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }
}
