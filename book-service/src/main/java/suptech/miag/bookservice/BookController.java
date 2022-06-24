package suptech.miag.bookservice;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/author/")
public class BookController {

    private final IBookRepository iBookRepository;
    private IBookService iBookService;

    public BookController(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    // Create
    @PostMapping("add")
    public BookModel addBook(@RequestBody BookModel bookModel) {
        Date date = new Date();
        bookModel.setDate(date);
        return iBookService.addBook(bookModel);

    }

    // read
    @GetMapping("get/{id}")
    public Optional<BookModel> getBook(@PathVariable Long id){
        return iBookRepository.findById(id);
    }

    // update
    @PatchMapping("update/{id}")
    public BookModel updateBook(@PathVariable("id") final Long id, @RequestBody BookModel bookModel) {
        return  iBookRepository.findById(id)
                .map(bookModel1 -> {
                    bookModel.setTitle(bookModel1.getTitle());
                    bookModel1 = bookModel;
                    return iBookRepository.save(bookModel1);
                }).orElseGet(() ->{
                    return null;
                });
    }

    // Delete
    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable("id") final Long id) {
        iBookRepository.deleteById(id);
    }




}
