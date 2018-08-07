package br.gov.sp.prodesp.sim.servicosprefeituras.model;

import java.io.Serializable;
import java.util.Calendar;

import br.gov.sp.prodesp.sim.servicosprefeituras.model.enums.SituacaoMultaEnum;

public class MultaRetorno implements Serializable {

    private long id;
    private Calendar dataInfracao;
    private Calendar horaInfracao;
    private String pontosCnh;
    private String placa;
    private String marca;
    private String especie;
    private Calendar dataEmissao;
    private String nomeProprietario;
    private String descricaoInfracao;
    private String enquadramento;
    private String localInfracao;
    private Calendar dataLimite;
    private SituacaoMultaEnum situacaoMultaEnum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDataInfracao() {
        return dataInfracao;
    }

    public void setDataInfracao(Calendar dataInfracao) {
        this.dataInfracao = dataInfracao;
    }

    public Calendar getHoraInfracao() {
        return horaInfracao;
    }

    public void setHoraInfracao(Calendar horaInfracao) {
        this.horaInfracao = horaInfracao;
    }

    public String getPontosCnh() {
        return pontosCnh;
    }

    public void setPontosCnh(String pontosCnh) {
        this.pontosCnh = pontosCnh;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Calendar getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Calendar dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getDescricaoInfracao() {
        return descricaoInfracao;
    }

    public void setDescricaoInfracao(String descricaoInfracao) {
        this.descricaoInfracao = descricaoInfracao;
    }

    public String getEnquadramento() {
        return enquadramento;
    }

    public void setEnquadramento(String enquadramento) {
        this.enquadramento = enquadramento;
    }

    public String getLocalInfracao() {
        return localInfracao;
    }

    public void setLocalInfracao(String localInfracao) {
        this.localInfracao = localInfracao;
    }

    public Calendar getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Calendar dataLimite) {
        this.dataLimite = dataLimite;
    }

    public SituacaoMultaEnum getSituacaoMultaEnum() {
        return situacaoMultaEnum;
    }

    public void setSituacaoMultaEnum(SituacaoMultaEnum situacaoMultaEnum) {
        this.situacaoMultaEnum = situacaoMultaEnum;
    }


//TODO - Troca Serializable para Parcelable
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel out, int flags) {
//        out.writeLong(id);
//        out.writeLong(dataInfracao.getTime());
//        out.writeString(horaInfracao);
//        out.writeString(pontosCnh);
//        out.writeString(placa);
//        out.writeString(situacaoMultaEnum);
//    }
//
//    public static final Parcelable.Creator<MultaRetorno> CREATOR
//            = new Parcelable.Creator<MultaRetorno>() {
//        public MultaRetorno createFromParcel(Parcel in) {
//            return new MultaRetorno(in);
//        }
//
//        public MultaRetorno[] newArray(int size) {
//            return new MultaRetorno[size];
//        }
//    };
//
//    private MultaRetorno(Parcel in) {
//        id = in.readLong();
//        dataInfracao = new Date(in.readLong());
//        pontosCnh = in.readString();
//        placa = in.readString();
//    }
}
