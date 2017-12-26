package handlers;
import request.*;
/**
 * Created by sss on 25/12/2017.
 */
public abstract class PurchasePower {
    protected static final double BASE = 500;
    protected PurchasePower successor;          //left child
    protected PurchasePower secondSuccessor;    //right child

    abstract public double getAllowable();
    abstract protected String getRole();

    public void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    public void setSecondSuccessor(PurchasePower secondSuccessor) {
        this.secondSuccessor = secondSuccessor;
    }

    public PurchasePower getSuccessor() {
        return successor;
    }

    public PurchasePower getSecondSuccessor() {
        return secondSuccessor;
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= this.getAllowable() ) {

            if (successor!=null)
            {
                if (request.getAmount()<=successor.getAllowable())
                {
                    successor.processRequest(request);
                }
                else {

                    // left -> right , or self
                    if (successor.secondSuccessor!=null)
                    {
                        if (successor.secondSuccessor.getAllowable()>=request.getAmount())
                        {
                            successor.processRequest(request);
                        }
                        else  System.out.println(this.getRole() + " will approve $" + request.getAmount());

                    }
                    else System.out.println(this.getRole() + " will approve $" + request.getAmount());
                }
            }
            else {
                System.out.println(this.getRole() + " will approve $" + request.getAmount());
            }

        } else if (request.getAmount() > this.getAllowable() ) {

            if (secondSuccessor!=null) {

                    secondSuccessor.processRequest(request);
            }
            else System.out.println("Even "+ this.getRole() + " can't approve $" + request.getAmount() +", Please request lower expenditure!");



        }




    }
}