package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_warehouse")
public class BookWarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @OneToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
    @Column(name = "count")
    private Integer count;

    public BookWarehouseEntity() {}

    public BookWarehouseEntity(BookEntity book, Integer count) {
        this.book = book;
        this.count = count;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
