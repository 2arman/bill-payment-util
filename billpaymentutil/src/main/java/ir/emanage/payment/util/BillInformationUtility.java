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

    public BillType getBillType(String billId) {
        return BillType.valueOfByCode(billId.substring(billId.length() - 2, billId.length() - 1));
    }

    public String getSubCompanyCode(String billId) {
        return billId.substring(billId.length() - 5, billId.length() - 2);
    }
}
