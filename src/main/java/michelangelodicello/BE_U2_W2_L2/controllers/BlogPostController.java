package michelangelodicello.BE_U2_W2_L2.controllers;

import michelangelodicello.BE_U2_W2_L2.entities.BlogPost;
import michelangelodicello.BE_U2_W2_L2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAll();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPostService.getById(id);
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost body) {
        return blogPostService.save(body);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody BlogPost body) {
        return blogPostService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id) {
        blogPostService.findByIdAndDelete(id);
    }
}