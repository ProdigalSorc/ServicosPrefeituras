package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

public class CryptException extends RuntimeException {
    private static final long serialVersionUID = -219060929694937175L;

    public CryptException() {
        super();
    }

    public CryptException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public CryptException(String detailMessage) {
        super(detailMessage);
    }

    public CryptException(Throwable throwable) {
        super(throwable);
    }
}
