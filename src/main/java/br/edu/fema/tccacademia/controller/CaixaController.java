package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("caixa")
public class CaixaController {

    @Autowired
    private CaixaRepository repository;


}
