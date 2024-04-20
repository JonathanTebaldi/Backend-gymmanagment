package br.edu.fema.tccacademia.models.treino;

public record DadosListagemTreino(
        String nomeExercicio,
        String descricao,
        String series,
        String musculo
) {
    public DadosListagemTreino(Treino treino){
        this(treino.getNomeExercicio(), treino.getDescricao(), treino.getSeries(), treino.getMusculo());
    }
}
