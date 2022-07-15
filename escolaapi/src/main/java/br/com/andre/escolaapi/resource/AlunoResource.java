package br.com.andre.escolaapi.resource;

import br.com.andre.escolaapi.model.Aluno;
import br.com.andre.escolaapi.repository.AlunoRepository;
import br.com.andre.escolaapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    //injetando o service do aluno
    @Autowired
    private AlunoService alunoService;

    //list esta aqui, igual do service
    //tipo o order by tlg?

    //select
    @GetMapping("/todos")
    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll(Sort.by("nomealuno").ascending());
    }

    //insert
    @PostMapping
        public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Aluno alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    //buscar por id
        @GetMapping("/{id}")
            public ResponseEntity<Aluno> buscarPeloId(@PathVariable Long id){
            Optional<Aluno> aluno = alunoRepository.findById(id);
            return aluno.isPresent() ? ResponseEntity.ok(aluno.get()) : ResponseEntity.notFound().build();
        }

        //deletar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        alunoRepository.deleteById(id);
    }

}




