package br.com.andre.escolaapi.service;

import br.com.andre.escolaapi.model.Curso;
import br.com.andre.escolaapi.repository.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //importante
    public Curso atualizar(Integer id, Curso curso) {
        Curso cursoSalvo = buscarCursoExistente(id);

        BeanUtils.copyProperties(curso, cursoSalvo, "id");

        return cursoRepository.save(cursoSalvo);
    }

    //put

    private Curso buscarCursoExistente(Integer id) {
        Optional<Curso> cursoSalvo = cursoRepository.findById(id);
        if (!cursoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }

        return cursoSalvo.get();
    }


}
