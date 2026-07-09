package michelangelodicello.BE_U2_W2_L2.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogPostPayloadDTO {
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private Long authorId;
}