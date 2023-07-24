package project.vilsoncake.BookOnlineStore.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.vilsoncake.BookOnlineStore.entity.BookAvatarEntity;
import project.vilsoncake.BookOnlineStore.entity.BookEntity;
import project.vilsoncake.BookOnlineStore.repository.BookAvatarRepository;
import project.vilsoncake.BookOnlineStore.service.AvatarService;

import java.io.IOException;

@Service
@Slf4j
public class BookAvatarServiceImpl implements AvatarService {

    private final BookAvatarRepository bookAvatarRepository;

    public BookAvatarServiceImpl(BookAvatarRepository bookAvatarRepository) {
        this.bookAvatarRepository = bookAvatarRepository;
    }

    @Override
    public void addAvatar(BookEntity book, MultipartFile avatar) {
        try {
            BookAvatarEntity bookAvatar = new BookAvatarEntity(
                    avatar.getOriginalFilename(),
                    avatar.getSize(),
                    avatar.getBytes(),
                    book
            );
            bookAvatarRepository.save(bookAvatar);
        } catch (IOException e) {
            log.error("Cannot add avatar to book with id {}", book.getBookId());
        }
    }

    @Override
    public BookAvatarEntity getAvatar(Long bookId) {
        if (bookAvatarRepository.findById(bookId).isEmpty()) {
            return null;
        }
        return bookAvatarRepository.findById(bookId).get();
    }
}
