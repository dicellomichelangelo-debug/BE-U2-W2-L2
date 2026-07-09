package michelangelodicello.BE_U2_W2_L2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "blog_posts")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}