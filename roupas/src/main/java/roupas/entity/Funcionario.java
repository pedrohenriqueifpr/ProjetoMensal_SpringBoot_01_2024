package roupas.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Idade não pode ser nula")
    @Min(value = 0, message = "Idade deve ser maior ou igual a 0")
    private int idade;

    @NotBlank(message = "Matrícula não pode ser vazia")
    private String matricula;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<Venda> vendas; 
}
