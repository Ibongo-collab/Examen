package suptech.miag.authorservice.author;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/author/")

public class AuthorController {
    private final IAuthorRepository iAuthorRepository;
    private IAuthorService iAuthorService;

    public AuthorController(IAuthorRepository iAuthorRepository) {
        this.iAuthorRepository = iAuthorRepository;
    }


    // Create
    @PostMapping("add")
    public Author addAuthor(@RequestBody Author author) {
        return iAuthorService.addAuthor(author);
    }

    // read
    @GetMapping("get/{id}")
    public Optional<Author> getAuthor(@PathVariable Long id){
        return iAuthorRepository.findById(id);
    }

    // update
    @PatchMapping("update/{id}")
    public Author updateAuthor(@PathVariable("id") final Long id, @RequestBody Author author) {
        return  iAuthorRepository.findById(id)
                .map(author1 -> {
                    author.setName(author1.getName());
                    author1 = author;
                    return iAuthorRepository.save(author1);
                }).orElseGet(() ->{
                    return null;
                });
    }

    // Delete
    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable("id") final Long id) {
        iAuthorRepository.deleteById(id);
    }

}
