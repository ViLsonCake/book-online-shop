package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.vilsoncake.BookOnlineStore.entity.BookAvatarEntity;
import project.vilsoncake.BookOnlineStore.entity.UserEntity;
import project.vilsoncake.BookOnlineStore.repository.BookAvatarRepository;
import project.vilsoncake.BookOnlineStore.service.AvatarService;

@Service
@Slf4j
public class BookAvatarServiceImpl implements AvatarService {

    private final BookAvatarRepository bookAvatarRepository;

    public BookAvatarServiceImpl(BookAvatarRepository bookAvatarRepository) {
        this.bookAvatarRepository = bookAvatarRepository;
    }

    @Override
    public void addAvatar(Long bookId, UserEntity user) {
        BookAvatarEntity bookAvatar = bookAvatarRepository.findById(bookId).isPresent() ?
                bookAvatarRepository.findById(bookId).get() : null;

        if (bookAvatar == null)
            log.warn("Avatar with id {} don't exist", bookId);


    }

    @Override
    public BookAvatarEntity getAvatar(Long bookId) {
        if (bookAvatarRepository.findById(bookId).isEmpty()) {
            return null;
        }

        return bookAvatarRepository.findById(bookId).get();

    }
}
