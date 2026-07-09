package michelangelodicello.BE_U2_W2_L2.payloads;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogPostPayloadDTO {
    @NotBlank(message = "La categoria è obbligatoria")
    private String categoria;

    @NotBlank(message = "Il titolo è obbligatorio")
    private String titolo;

    @NotBlank(message = "Il contenuto è obbligatorio")
    private String contenuto;

    @Min(value = 1, message = "Il tempo di lettura deve essere di almeno 1 minuto")
    private int tempoDiLettura;

    @NotNull(message = "L'id dell'autore è obbligatorio")
    private Long authorId;
}