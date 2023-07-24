package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.entity.BookWarehouseEntity;
import project.vilsoncake.BookOnlineStore.repository.WarehouseRepository;
import project.vilsoncake.BookOnlineStore.service.WarehouseService;

@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public void addBookToWarehouse(BookEntity book, Integer startCount) {
        BookWarehouseEntity bookWarehouse = new BookWarehouseEntity(book, startCount);
        warehouseRepository.save(bookWarehouse);
    }

    @Override
    public BookWarehouseEntity getBookWarehouse(BookEntity book) {
        return warehouseRepository.findByBook(book);
    }

    @Override
    public void changeBooksCount(BookEntity book, Integer newCount) {
        BookWarehouseEntity bookWarehouse = warehouseRepository.findByBook(book);
        bookWarehouse.setCount(bookWarehouse.getCount() + newCount);
        warehouseRepository.save(bookWarehouse);
    }
}
