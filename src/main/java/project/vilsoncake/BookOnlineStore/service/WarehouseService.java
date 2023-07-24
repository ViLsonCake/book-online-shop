package project.vilsoncake.BookOnlineStore.service;

import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.entity.BookWarehouseEntity;

public interface WarehouseService {
    void addBookToWarehouse(BookEntity book, Integer startCount);
    BookWarehouseEntity getBookWarehouse(BookEntity book);
    void changeBooksCount(BookEntity book, Integer newCount);
}
