package project.vilsoncake.BookOnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.vilsoncake.BookOnlineStore.entity.BookAvatarEntity;

@Repository
public interface BookAvatarRepository extends JpaRepository<BookAvatarEntity, Long> {
}
