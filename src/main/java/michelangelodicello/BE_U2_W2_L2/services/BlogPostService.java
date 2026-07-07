package michelangelodicello.BE_U2_W2_L2.services;

import michelangelodicello.BE_U2_W2_L2.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private final List<BlogPost> blogPostsList = new ArrayList<>();

    public List<BlogPost> getAll() {
        return this.blogPostsList;
    }

    public BlogPost getById(Long id) {
        return this.blogPostsList.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Blog post con id " + id + " non trovato!"));
    }

    public BlogPost save(BlogPost body) {
        body.setId(new Random().nextLong(1, 10000));
        body.setCover("https://picsum.photos/200/300");
        this.blogPostsList.add(body);
        return body;
    }

    public BlogPost findByIdAndUpdate(Long id, BlogPost body) {
        BlogPost found = this.getById(id);
        found.setCategoria(body.getCategoria());
        found.setTitolo(body.getTitolo());
        found.setContenuto(body.getContenuto());
        found.setTempoDiLettura(body.getTempoDiLettura());
        return found;
    }

    public void findByIdAndDelete(Long id) {
        BlogPost found = this.getById(id);
        this.blogPostsList.remove(found);
    }
}