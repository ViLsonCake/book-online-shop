package project.vilsoncake.BookOnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.vilsoncake.BookOnlineStore.entity.UserAvatarEntity;

@Repository
public interface UserAvatarRepository extends JpaRepository<UserAvatarEntity, Long> {
}
