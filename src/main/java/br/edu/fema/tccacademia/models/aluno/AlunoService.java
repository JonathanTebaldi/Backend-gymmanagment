package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
