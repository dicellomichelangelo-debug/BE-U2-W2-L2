package michelangelodicello.BE_U2_W2_L2.services;

import michelangelodicello.BE_U2_W2_L2.entities.Author;
import michelangelodicello.BE_U2_W2_L2.entities.BlogPost;
import michelangelodicello.BE_U2_W2_L2.exception.NotFoundException;
import michelangelodicello.BE_U2_W2_L2.payloads.BlogPostPayloadDTO;
import michelangelodicello.BE_U2_W2_L2.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepo;

    @Autowired
    private AuthorService authorService;

    public Page<BlogPost> getAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogPostRepo.findAll(pageable);
    }

    public BlogPost getById(Long id) {
        return blogPostRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Blog post con id " + id + " non trovato!"));
    }


    public BlogPost save(BlogPostPayloadDTO body) {
        Author author = authorService.getById(body.getAuthorId());

        BlogPost newPost = new BlogPost();
        newPost.setCategoria(body.getCategoria());
        newPost.setTitolo(body.getTitolo());
        newPost.setContenuto(body.getContenuto());
        newPost.setTempoDiLettura(body.getTempoDiLettura());
        newPost.setCover("https://picsum.photos/200/300");
        newPost.setAuthor(author);

        return blogPostRepo.save(newPost);
    }

    public BlogPost findByIdAndUpdate(Long id, BlogPostPayloadDTO body) {
        BlogPost found = this.getById(id);
        Author author = authorService.getById(body.getAuthorId());

        found.setCategoria(body.getCategoria());
        found.setTitolo(body.getTitolo());
        found.setContenuto(body.getContenuto());
        found.setTempoDiLettura(body.getTempoDiLettura());
        found.setAuthor(author);

        return blogPostRepo.save(found);
    }

    public void findByIdAndDelete(Long id) {
        BlogPost found = this.getById(id);
        blogPostRepo.delete(found);
    }
}