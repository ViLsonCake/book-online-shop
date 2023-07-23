package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_avatar")
public class BookAvatarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avatarId;
    @Column(name = "filename")
    private String filename;
    @Column(name = "size")
    private Long size;
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

    public Long getAvatarId() {
        return avatarId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
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
