package project.vilsoncake.BookOnlineStore.constant;

import java.util.List;

public class NameConst {

    public static final String DEFAULT_AVATAR_FILENAME = "default-user.jpg";
    public static final String PATH_TO_IMAGE = "/src/main/resources/static/img/";
    public static final List<String> BINDINGS_LIST = List.of(
            "Saddle Stitching",
            "Perfect Binding",
            "Softcover",
            "Case Binding",
            "Hardcover",
            "Board Book Binding",
            "Wire Binding",
            "Spiral Binding"
    );
    public static final List<String> FILE_EXTENSIONS = List.of("jpeg", "png", "svg");
    public static final List<String> BOOK_CATEGORIES = List.of(
            "Fiction",
            "Non-Fiction",
            "Novel",
            "Romance",
            "Children’s Books",
            "Biography",
            "Autobiography",
            "Text-books",
            "Political Books",
            "Academic Books",
            "Mystery",
            "Thrillers",
            "Poetry Books",
            "Cook Books",
            "History Books"
    );
}
