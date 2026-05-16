package cn.edu.guet.demo2.exception;

public class IllegalUserException extends RuntimeException {
    public IllegalUserException(String message) {
        super(message);
    }
}
