package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.repository.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("modalidades")
public class ModalidadeController {

    @Autowired
    private ModalidadeRepository repository;



}
