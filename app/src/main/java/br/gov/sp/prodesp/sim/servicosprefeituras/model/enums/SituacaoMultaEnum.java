package br.gov.sp.prodesp.sim.servicosprefeituras.model.enums;

public enum SituacaoMultaEnum {
    AIT_EM_ANALISE(1, "Em análise"),
    AIT_PROCESSADO(2, "Processado"),
    AIT_CANCELADO(3, "Cancelado");

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
