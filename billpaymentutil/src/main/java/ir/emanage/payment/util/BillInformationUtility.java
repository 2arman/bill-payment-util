package ir.emanage.payment.util;

/**
 * @author Arman
 * Date: 11/6/19
 * Time: 12:15 PM
 **/
public class BillInformationUtility {
    public Long getAmountFromPayId(String payId) {
        String amount = payId.substring(0, payId.length() - 5) + "000";
        return Long.valueOf(amount);
    }
}
