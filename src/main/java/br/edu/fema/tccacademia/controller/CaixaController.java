package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.caixa.Caixa;
import br.edu.fema.tccacademia.models.caixa.CaixaService;
import br.edu.fema.tccacademia.models.caixa.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("caixa")
public class CaixaController {

    @Autowired
    private CaixaService caixaService;

    @PostMapping("/abrir")
    private ResponseEntity<Caixa> abrirCaixa(@RequestParam Double valorInicial){
        Caixa caixa = caixaService.abrirCaixa(valorInicial);
        return ResponseEntity.status(HttpStatus.CREATED).body(caixa);
    }

    @PostMapping("/suprir/{id}")
    private ResponseEntity<Void> suprirCaixa(@PathVariable UUID id, @RequestParam Double valor){
        caixaService.suprirCaixa(id, valor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/pagar/{id}")
    private ResponseEntity<List<Pagamento>> registrarPagamento(@PathVariable UUID id, @RequestParam Double valor, @RequestParam String descricao){
        Pagamento pagamento = caixaService.registrarPagamento(id, valor, descricao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/historico/{id}")
    private ResponseEntity<List<Pagamento>> historicoPagamento(@PathVariable UUID id){
        List<Pagamento> historico = caixaService.emitirHistoricoPagamento(id);
        return ResponseEntity.ok(historico);
    }

    @GetMapping("/fechar/{id}")
    private ResponseEntity<Caixa> fecharCaixa(@PathVariable UUID id){
        Caixa caixa = caixaService.fecharCaixa(id);
        return ResponseEntity.ok(caixa);
    }
}
