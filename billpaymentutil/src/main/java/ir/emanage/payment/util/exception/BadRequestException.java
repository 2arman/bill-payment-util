package ir.emanage.payment.util.exception;

import java.util.List;

/**
 * @author Arman
 * Date: 11/6/19
 * Time: 10:55 AM
 **/
public class BadRequestException extends RuntimeException {
    private List<String> invalidIds;

    public BadRequestException(String message, List<String> invalidIds) {
        super(message);
        this.invalidIds = invalidIds;
    }

    public List<String> getInvalidIds() {
        return invalidIds;
    }

    public void setInvalidIds(List<String> invalidIds) {
        this.invalidIds = invalidIds;
    }
}
