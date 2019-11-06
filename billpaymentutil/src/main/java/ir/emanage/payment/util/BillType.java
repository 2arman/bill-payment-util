package ir.emanage.payment.util;

/**
 * @author Arman
 * Date: 11/6/19
 * Time: 10:35 AM
 **/
public enum BillType {
    UNKNOWN("0"),
    WATER("1"),
    ELECTRICITY("2"),
    GAS("3"),
    IMMOBILE_PHONE("4"),
    MOBILE_PHONE("5"),
    MUNICIPALITY_DUE("6"),
    TAX("7"),
    POLICE("8"),
    CUSTOM("9"),
    OTHER("10");
    private final String code;

    BillType(String code) {
        this.code = code;
    }

    public static BillType valueOfByCode(String code) {
        for (BillType billType : BillType.values()) {
            if (billType.getCode().equals(code)) {
                return billType;
            }
        }
        return BillType.UNKNOWN;
    }

    public String getCode() {
        return code;
    }
}
