package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matricula")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

}