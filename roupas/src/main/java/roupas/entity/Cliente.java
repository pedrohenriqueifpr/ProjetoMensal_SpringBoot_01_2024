package roupas.entity;

import java.util.List;
import org.hibernate.validator.constraints.br.CPF;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @CPF(message = "CPF inválido")
    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "^(?:\\d{3}\\.){2}\\d{3}-\\d{2}$",
    message = "CPF inválido, deve ser no formato XXX.XXX.XXX-XX")
    private String cpf;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 0, message = "Idade deve ser maior que 0")
    private Integer idade;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "^\\+\\d{1,3}\\(\\d{2,3}\\)\\d{4,5}-\\d{4}$", 
    message = "Número de celular inválido, deve ser no formato +XXX(XXX)XXXXX-XXXX")
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
}
