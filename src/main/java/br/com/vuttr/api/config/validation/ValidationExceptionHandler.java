package br.com.vuttr.api.config.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationHandler(MethodArgumentNotValidException ex){
        List<FormErroDto> formErro = new ArrayList<>();

        List<FieldError> erros = ex.getBindingResult().getFieldErrors();

        erros.forEach( e -> {
            FormErroDto erro = new FormErroDto(e.getField(),e.getDefaultMessage());
            formErro.add(erro);
        });

        return ResponseEntity.badRequest().body(formErro);
    }


}
