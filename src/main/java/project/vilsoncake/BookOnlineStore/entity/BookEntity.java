package project.vilsoncake.BookOnlineStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "issue_year")
    private Integer issueYear;
    @Column(name = "page")
    private Integer page;
    @Column(name = "language")
    private String language;
    @Column(name = "binding")
    private String binding;
    @Column(name = "description")
    private String description;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "availability")
    private boolean availability;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    private BookAvatarEntity avatar;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public BookEntity() {}

    public BookEntity(String name, String author, String publisher, Integer issueYear, Integer page, String language, String binding, String description, String isbn, boolean availability, BookAvatarEntity avatar, OrderEntity order) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.issueYear = issueYear;
        this.page = page;
        this.language = language;
        this.binding = binding;
        this.description = description;
        this.isbn = isbn;
        this.availability = availability;
        this.avatar = avatar;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public BookAvatarEntity getAvatar() {
        return avatar;
    }

    public void setAvatar(BookAvatarEntity avatar) {
        this.avatar = avatar;
    }
}
