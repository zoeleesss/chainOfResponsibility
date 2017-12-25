package handlers;

/**
 * Created by sss on 25/12/2017.
 */
public class VicePresidentPPower extends PurchasePower {

    protected double getAllowable() {
        return BASE * 40;
    }

    protected String getRole() {
        return "Vice President";
    }
}
