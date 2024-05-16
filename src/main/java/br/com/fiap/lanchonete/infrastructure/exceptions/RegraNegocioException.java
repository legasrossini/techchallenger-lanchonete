package br.com.fiap.lanchonete.infrastructure.exceptions;

public class RegraNegocioException extends RuntimeException {

    public RegraNegocioException(String msg) {
        super(msg);
     }
  
     public RegraNegocioException(String msg, Throwable throwable) {
        super(msg, throwable);
     }

}
