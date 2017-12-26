package handlers;

/**
 * Created by sss on 25/12/2017.
 */
public class ManagerPPower extends PurchasePower {

    public double getAllowable() {
        return BASE * 10;
    }

    protected String getRole() {
        return "Manager";
    }
}