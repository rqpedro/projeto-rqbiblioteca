package com.rafaelqueiroz.rqbiblioteca.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
}
