package michelangelodicello.BE_U2_W2_L2.services;

import michelangelodicello.BE_U2_W2_L2.entities.Author;
import michelangelodicello.BE_U2_W2_L2.exception.NotFoundException;
import michelangelodicello.BE_U2_W2_L2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    // GET con Paginazione e Ordinamento
    public Page<Author> getAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return authorRepo.findAll(pageable);
    }

    public Author getById(Long id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Autore con id " + id + " non trovato!"));
    }

    public Author save(Author body) {
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        return authorRepo.save(body);
    }

    public Author findByIdAndUpdate(Long id, Author body) {
        Author found = this.getById(id);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        found.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        return authorRepo.save(found);
    }

    public void findByIdAndDelete(Long id) {
        Author found = this.getById(id);
        authorRepo.delete(found);
    }
}