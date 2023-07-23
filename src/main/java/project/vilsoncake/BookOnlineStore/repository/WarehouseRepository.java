package project.vilsoncake.BookOnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.entity.BookWarehouseEntity;

@Repository
public interface WarehouseRepository extends JpaRepository<BookWarehouseEntity, Long> {
    BookWarehouseEntity findByBook(BookEntity book);
}
