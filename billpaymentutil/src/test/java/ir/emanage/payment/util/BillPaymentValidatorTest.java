package ir.emanage.payment.util;

import ir.emanage.payment.util.exception.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Arman
 * Date: 11/5/19
 * Time: 4:16 PM
 **/
class BillPaymentValidatorTest {

    @Test
    void validateBillsInformation_Successful() {
        new BillPaymentValidator().validateBill("5516674930156", "78782730");
        new BillPaymentValidator().validateBill("9395954204127", "39580780");
        new BillPaymentValidator().validateBill("9943873404129", "28980711");
    }

    @Test
    void validateBill_Failed_WhenInvalidPayId() {
        assertThrows(BadRequestException.class, () ->
                new BillPaymentValidator().validateBill("5516674930156", "78782740"));

    }

    @Test
    void validateBill_Failed_WhenInvalidBillId() {
        assertThrows(BadRequestException.class, () ->
                new BillPaymentValidator().validateBill("5516674932156", "78782730"));

    }

    @Test
    void validateBill_Failed_WhenNotMatchedBillIdPayId() {
        assertThrows(BadRequestException.class, () ->
                new BillPaymentValidator().validateBill("5516674930156", "78782731"));

    }

    @Test
    void validateBill_Failed_WhenBillIdInvalidFormat() {
        assertThrows(BadRequestException.class, () ->
                new BillPaymentValidator().validateBill("551667a4930156", "78782731"));
        assertThrows(BadRequestException.class, () ->
                new BillPaymentValidator().validateBill("493016", "78782731"));
    }

    @Test
    void validateBill_Failed_WhenPayIdInvalidFormat() {
        assertThrows(BadRequestException.class, () ->
                new BillPaymentValidator().validateBill("551667a4930156", "78782a731"));
        assertThrows(BadRequestException.class, () ->
                new BillPaymentValidator().validateBill("551667a4930156", "78781"));
    }
}