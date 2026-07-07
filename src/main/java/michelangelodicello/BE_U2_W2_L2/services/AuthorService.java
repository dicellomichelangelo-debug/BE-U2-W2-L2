package michelangelodicello.BE_U2_W2_L2.services;

import michelangelodicello.BE_U2_W2_L2.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private final List<Author> authorsList = new ArrayList<>();

    public List<Author> getAll() {
        return this.authorsList;
    }

    public Author getById(Long id) {
        return this.authorsList.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Autore con id " + id + " non trovato!"));
    }

    public Author save(Author body) {
        body.setId(new Random().nextLong(1, 10000));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        this.authorsList.add(body);
        return body;
    }

    public Author findByIdAndUpdate(Long id, Author body) {
        Author found = this.getById(id);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        found.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        return found;
    }

    public void findByIdAndDelete(Long id) {
        Author found = this.getById(id);
        this.authorsList.remove(found);
    }
}