package michelangelodicello.BE_U2_W2_L2.controllers;

import jakarta.validation.Valid;
import michelangelodicello.BE_U2_W2_L2.entities.BlogPost;
import michelangelodicello.BE_U2_W2_L2.payloads.BlogPostPayloadDTO;
import michelangelodicello.BE_U2_W2_L2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public Page<BlogPost> getAllBlogPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return blogPostService.getAll(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPostService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogPost(@RequestBody @Valid BlogPostPayloadDTO body) {
        return blogPostService.save(body);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody @Valid BlogPostPayloadDTO body) {
        return blogPostService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPost(@PathVariable Long id) {
        blogPostService.findByIdAndDelete(id);
    }
}