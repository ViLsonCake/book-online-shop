package project.vilsoncake.BookOnlineStore.service;

import project.vilsoncake.BookOnlineStore.entity.BookAvatarEntity;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;

import java.io.File;
import java.io.IOException;

public interface AvatarService {

//    boolean addDefaultAvatar(UserEntity user) throws IOException;
    void addAvatar(Long bookId, UserEntity user);
    BookAvatarEntity getAvatar(Long bookId);
}
