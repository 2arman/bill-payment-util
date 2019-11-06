package ir.emanage.payment.util;

import ir.emanage.payment.util.exception.BadRequestException;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * @author Arman
 * Date: 11/5/19
 * Time: 11:05 PM
 **/
public class BillPaymentValidator {

    /**
     * @param billId bill id with format regexp = "\\d{6,13}
     * @param payId  pay id with format regexp = "\\d{6,13}
     * @throws BadRequestException when invalid bill id or pay id
     */
    public void validateBill(String billId, String payId) throws BadRequestException {
        validateFormat(billId);
        validateFormat(payId);
        validateBillId(billId);
        validatePayId(payId);
        validateBillAndPayId(billId, payId);
    }

    private void validateBillAndPayId(String billId, String payId) {
        try {
            validateBillId(normalize(billId) + normalize(payId));
        } catch (BadRequestException e) {
            e.setInvalidIds(Arrays.asList(billId, payId));
            throw e;
        }
    }

    private void validateBillId(String billId) {
        char[] billCharArray = billId.substring(0, billId.length() - 1).toCharArray();
        short billIdControl = Short.parseShort(billId.substring(billId.length() - 1));
        short calculatedBillIdControl = getCalculatedControlDigit(billCharArray);
        if (billIdControl != calculatedBillIdControl) {
            throw new BadRequestException("Invalid bill", Collections.singletonList(billId));
        }
    }

    private void validatePayId(String payId) {
        char[] payCharArray = payId.substring(0, payId.length() - 2).toCharArray();
        short payIdControl = Short.parseShort(payId.substring(payId.length() - 2, payId.length() - 1));
        short calculatedPayIdControl = getCalculatedControlDigit(payCharArray);
        if (calculatedPayIdControl != payIdControl) {
            throw new BadRequestException("Invalid pay", Collections.singletonList(payId));
        }
    }

    private String normalize(String id) {
        return String.valueOf(Long.valueOf(id));
    }

    private void validateFormat(String id) {
        String regex = "\\d{6,13}";
        if (!Pattern.compile(regex).matcher(id).matches()) {
            throw new BadRequestException("Invalid id format with regex:" + regex, Collections.singletonList(id));
        }
    }

    private short getCalculatedControlDigit(char[] charArray) {
        short calculatedBillIdControl;
        int sumOfFields = 0;
        int j = 2;
        for (int i = charArray.length - 1; i >= 0; i--) {
            short aChar = Short.parseShort(String.valueOf(charArray[i]));
            sumOfFields += (aChar * j);
            j++;
            if (j == 8) {
                j = 2;
            }
        }
        int mod = sumOfFields % 11;
        if (mod == 0 || mod == 1) {
            calculatedBillIdControl = 0;
        } else {
            calculatedBillIdControl = (short) (11 - mod);
        }
        return calculatedBillIdControl;
    }

}
