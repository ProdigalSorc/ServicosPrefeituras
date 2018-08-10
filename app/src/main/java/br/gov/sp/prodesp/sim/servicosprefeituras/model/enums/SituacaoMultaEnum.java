package br.gov.sp.prodesp.sim.servicosprefeituras.model.enums;

public enum SituacaoMultaEnum {
    AIT_AGUARDANDO(1, "Aguardando"),
    AIT_EM_ANALISE(2, "Em análise"),
    AIT_PROCESSADO(3, "Processado"),
    AIT_CANCELADO(4, "Cancelado");

    private int value;
    private String situacaoMulta;

    private SituacaoMultaEnum(int value, String situacaoMulta) {
        this.value = value;
        this.situacaoMulta = situacaoMulta;
    }

    public int getValue() {
        return value;
    }

    public String getSituacaoMulta() {
        return situacaoMulta;
    }
}
