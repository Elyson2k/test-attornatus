package attornatus.teste.javajr.resourcers.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class StandardError {

    private Integer status;
    private String msg;
    private LocalDateTime timeStamp;

    public StandardError(Integer status, String msg, LocalDateTime timeStamp) {
        super();
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }


}
