// TRATAR FUTURAMENTE

// package br.com.banco.managementservice.config;

// import br.com.banco.managementservice.domain.exception.ResourceNotFoundException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import java.util.HashMap;
// import java.util.Map;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//     }

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
//         Map<String, String> errors = new HashMap<>();
//         ex.getBindingResult().getFieldErrors().forEach(err ->
//             errors.put(err.getField(), err.getDefaultMessage())
//         );
//         return ResponseEntity.badRequest().body(errors);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleOtherExceptions(Exception ex) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + ex.getMessage());
//     }
// }
