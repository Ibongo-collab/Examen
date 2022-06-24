package suptech.miag.authorservice.author;

public class AuthorService implements IAuthorService{

    private IAuthorRepository iAuthorRepository;

    @Override
    public Author addAuthor(Author author) {
        String old_name = author.getName();

        if (author.getSexe().contains("masculin")) {
            author.setName("Mr " + old_name);
        } else {
            author.setName("Mdm " + old_name);
        }
        return iAuthorRepository.save(author);
    }
}
