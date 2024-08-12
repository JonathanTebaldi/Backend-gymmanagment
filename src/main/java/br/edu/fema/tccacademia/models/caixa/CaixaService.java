package br.edu.fema.tccacademia.models.caixa;

import br.edu.fema.tccacademia.repository.CaixaRepository;
import br.edu.fema.tccacademia.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CaixaService {

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;


    public Caixa abrirCaixa(Double valorInicial){
        Caixa caixa = new Caixa();
        caixa.setValorInicial(valorInicial);
        caixa.setValorFinal(valorInicial);
        caixa.setData(LocalDate.now());
        return caixaRepository.save(caixa);
    }

    public void suprirCaixa(UUID id, Double valor){
        Caixa caixa = caixaRepository.findById(id).orElseThrow(() -> new RuntimeException("Caixa não encontrado"));
        caixa.setValorFinal(caixa.getValorFinal() + valor);
        caixaRepository.save(caixa);
    }

    public Pagamento registrarPagamento(UUID id, Double valor, String descricao){
        Caixa caixa = caixaRepository.findById(id).orElseThrow(() -> new RuntimeException("Caixa não encontrado"));

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(valor);
        pagamento.setDescricao(descricao);
        pagamento.setDate(LocalDate.now());
        pagamento.setCaixa(caixa);
        caixa.setValorFinal(caixa.getValorFinal() + valor);

        pagamentoRepository.save(pagamento);
        caixaRepository.save(caixa);

        return pagamento;
    }

    public List<Pagamento> emitirHistoricoPagamento(UUID id){
        Caixa caixa = caixaRepository.findById(id).orElseThrow(() -> new RuntimeException("Caixa não encontrado"));
        return pagamentoRepository.findByCaixa(caixa);
    }

    public Caixa fecharCaixa(UUID id){
        Caixa caixa = caixaRepository.findById(id).orElseThrow(() -> new RuntimeException("Caixa não encontrado"));
        return caixa;
    }
}
