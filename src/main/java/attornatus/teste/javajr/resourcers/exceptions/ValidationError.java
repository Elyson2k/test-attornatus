package attornatus.teste.javajr.resourcers.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandardError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Integer status, String msg, LocalDateTime timeStamp) {
        super(status, msg, timeStamp);
    }

    public void addError(String field, String name) {
        erros.add(new FieldMessage(field,name));
    }

}
