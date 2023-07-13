package project.vilsoncake.BookOnlineStore.service;

import project.vilsoncake.BookOnlineStore.entity.AddressEntity;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;

public interface AddressService {

    boolean addUserAddress(AddressEntity address, UserEntity user);
}
