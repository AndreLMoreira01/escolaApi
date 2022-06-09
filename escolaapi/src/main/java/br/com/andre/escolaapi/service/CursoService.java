package br.com.andre.escolaapi.service;

import br.com.andre.escolaapi.model.Curso;
import br.com.andre.escolaapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodosCursos(){
        return cursoRepository.findAll();
    }


    public Curso salvar(Curso curso){
        return cursoRepository.save(curso);
    }
}
