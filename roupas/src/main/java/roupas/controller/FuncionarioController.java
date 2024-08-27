package roupas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import roupas.entity.Funcionario;
import roupas.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Funcionario funcionario) {
        try {
            String mensagem = funcionarioService.save(funcionario);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Funcionario funcionario, @PathVariable long id) {
        try {
            String mensagem = funcionarioService.update(funcionario, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensagem = funcionarioService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable long id) {
        try {
            Funcionario funcionario = funcionarioService.findById(id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Funcionario>> findAll() {
        try {
            List<Funcionario> funcionarios = funcionarioService.findAll();
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Funcionario>> findByNome(@RequestParam String nome) {
        try {
            List<Funcionario> funcionarios = funcionarioService.findByNome(nome);
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMatricula")
    public ResponseEntity<Funcionario> findByMatricula(@RequestParam String matricula) {
        try {
            Funcionario funcionario = funcionarioService.findByMatricula(matricula);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByFaixaEtaria")
    public ResponseEntity<List<Funcionario>> findByFaixaEtaria(@RequestParam int idadeMin, @RequestParam int idadeMax) {
        try {
            List<Funcionario> funcionarios = funcionarioService.findByFaixaEtaria(idadeMin, idadeMax);
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
