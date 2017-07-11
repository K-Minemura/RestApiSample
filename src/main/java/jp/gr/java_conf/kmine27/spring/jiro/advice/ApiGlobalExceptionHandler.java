//package jp.gr.java_conf.kmine27.spring.jiro.advice;
//
//import org.springframework.boot.context.config.ResourceNotFoundException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//TODO
//@ControllerAdvice
//public class ApiGlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
//            Object body, HttpHeaders headers, HttpStatus status,
//            WebRequest request) {
//        return ResponseEntity.status(status).headers(headers).body("");
//    }
//
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex, HttpHeaders headers,
//            HttpStatus status, WebRequest request) {
//        return handleBindingResult(ex, ex.getBindingResult(), headers, status,
//                request);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleBindException(BindException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return handleBindingResult(ex, ex.getBindingResult(), headers, status,
//                request);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(
//            HttpMessageNotReadableException ex, HttpHeaders headers,
//            HttpStatus status, WebRequest request) {
//        if (ex.getCause() instanceof Exception) {
//            return handleExceptionInternal((Exception) ex.getCause(), null,
//                    headers, status, request);
//        } else {
//            return handleExceptionInternal(ex, null, headers, status, request);
//        }
//    }
//
//    protected ResponseEntity<Object> handleBindingResult(Exception ex,
//            BindingResult bindingResult, HttpHeaders headers,
//            HttpStatus status, WebRequest request) {
//        return handleExceptionInternal(ex, "", headers, status, request);
//    }
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<Object> handleResourceNotFoundException(
//            ResourceNotFoundException ex, WebRequest request) {
//        return handleResultMessagesNotificationException(ex, new HttpHeaders(),
//                HttpStatus.NOT_FOUND, request);
//    }
//
//    private ResponseEntity<Object> handleResultMessagesNotificationException(
//            ResourceNotFoundException ex, HttpHeaders headers,
//            HttpStatus status, WebRequest request) {
//        return handleExceptionInternal(ex, "", headers, status, request);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleSystemError(Exception ex,
//            WebRequest request) {
//        return handleExceptionInternal(ex, null, new HttpHeaders(),
//                HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
//
//}
