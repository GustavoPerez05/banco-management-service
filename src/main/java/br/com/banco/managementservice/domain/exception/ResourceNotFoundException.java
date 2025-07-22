package br.com.banco.managementservice.domain.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String menssage) {
        super(menssage);
    }
}
