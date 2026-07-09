package michelangelodicello.BE_U2_W2_L2.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorPayloadDTO {
    @NotBlank(message = "Il nome è obbligatorio")
    @Size(min = 2, max = 30, message = "Il nome deve essere compreso tra 2 e 30 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognome;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "L'email inserita non è valida")
    private String email;

    @NotNull(message = "La data di nascita è obbligatoria")
    private LocalDate dataDiNascita;
}