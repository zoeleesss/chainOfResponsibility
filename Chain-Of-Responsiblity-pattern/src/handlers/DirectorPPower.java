package handlers;

/**
 * Created by sss on 25/12/2017.
 */
public class DirectorPPower extends PurchasePower {

    protected double getAllowable() {
        return BASE * 20;
    }

    protected String getRole() {
        return "Director";
    }
}