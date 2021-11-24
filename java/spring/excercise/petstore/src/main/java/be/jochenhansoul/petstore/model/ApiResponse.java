package be.jochenhansoul.petstore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
public class ApiResponse {
    @Id
    @GeneratedValue
    private Integer code;
    private String type;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse that = (ApiResponse) o;
        return code.equals(that.code) && type.equals(that.type) && message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, type, message);
    }
}
