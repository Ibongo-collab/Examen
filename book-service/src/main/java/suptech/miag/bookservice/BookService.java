package suptech.miag.bookservice;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService implements IBookService{

    private final IBookRepository IBookRepository;

    public BookService(IBookRepository IBookRepository) {
        this.IBookRepository = IBookRepository;
    }


    @Override
    public BookModel addBook(BookModel bookModel) {
        List<BookModel> bookModels = IBookRepository.findAllById_author();
        if (bookModels.size() > 100) {
            System.out.println("Vous avez dépasser le nombre limite (100)");
        }
        return IBookRepository.save(bookModel);
    }
}
