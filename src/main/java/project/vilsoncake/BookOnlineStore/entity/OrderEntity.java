package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<BookEntity> books;

    public OrderEntity() {}

    public OrderEntity(UserEntity user, List<BookEntity> books) {
        this.user = user;
        this.books = books;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
