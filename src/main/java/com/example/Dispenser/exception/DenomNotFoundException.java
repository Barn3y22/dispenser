package com.example.Dispenser.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DenomNotFoundException extends RuntimeException{
	private String DenomName;
    private String fieldName;
    private Object fieldValue;

    public DenomNotFoundException( String denomName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", denomName, fieldName, fieldValue));
        this.DenomName = denomName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getDenomName() {
        return DenomName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
