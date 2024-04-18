package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pessoa")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;



}
