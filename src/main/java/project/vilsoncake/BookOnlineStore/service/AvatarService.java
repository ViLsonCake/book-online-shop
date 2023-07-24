package project.vilsoncake.BookOnlineStore.service;

import org.springframework.web.multipart.MultipartFile;
import project.vilsoncake.BookOnlineStore.entity.BookAvatarEntity;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;

import java.io.File;
import java.io.IOException;

public interface AvatarService {
    void addAvatar(BookEntity book, MultipartFile avatar);
    BookAvatarEntity getAvatar(Long bookId);
}
