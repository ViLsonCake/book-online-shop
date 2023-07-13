package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_avatar")
public class BookAvatarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avatarId;
    @Column(name = "byte_array")
    @Lob
    private byte[] byteArray;
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    public BookAvatarEntity() {}

    public BookAvatarEntity(byte[] byteArray, BookEntity book) {
        this.byteArray = byteArray;
        this.book = book;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
