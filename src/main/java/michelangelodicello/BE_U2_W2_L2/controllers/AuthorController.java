package michelangelodicello.BE_U2_W2_L2.controllers;

import jakarta.validation.Valid;
import michelangelodicello.BE_U2_W2_L2.entities.Author;
import michelangelodicello.BE_U2_W2_L2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Page<Author> getAllAuthors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return authorService.getAll(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody @Valid Author body) {
        return authorService.save(body);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody @Valid Author body) {
        return authorService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.findByIdAndDelete(id);
    }
}