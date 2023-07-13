package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_warehouse")
public class BookWarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "count")
    private Integer count;

    public BookWarehouseEntity() {}

    public BookWarehouseEntity(Long bookId, Integer count) {
        this.bookId = bookId;
        this.count = count;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
