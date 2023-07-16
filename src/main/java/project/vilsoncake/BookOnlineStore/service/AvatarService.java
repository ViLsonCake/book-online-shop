package project.vilsoncake.BookOnlineStore.service;

import project.vilsoncake.BookOnlineStore.entity.UserEntity;

import java.io.File;
import java.io.IOException;

public interface AvatarService {

    boolean addDefaultAvatar(UserEntity user) throws IOException;
    boolean addAvatar(File image, UserEntity user);
}
