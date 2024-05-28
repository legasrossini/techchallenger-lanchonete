package br.com.fiap.lanchonete.core.application.exceptions;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }
}
