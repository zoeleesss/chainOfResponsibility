package abstractHandler;
/**
 * @author lw
 *
 */
public abstract class Handler {
    protected Handler nextHandler = null;//下一个处理者,可以理解为链表的下一个节点
    public Handler getNextHandler() {
        return nextHandler;
    }
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract String handleRequest(String user,int num);//处理函数
}