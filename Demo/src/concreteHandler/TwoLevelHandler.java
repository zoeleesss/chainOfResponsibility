package concreteHandler;
import abstractHandler.Handler;
/**
 * @author lw
 *
 */
public class TwoLevelHandler extends Handler{
	/* (non-Javadoc)
	 * @see abstractHandler.Handler#handleRequest(java.lang.String, int)
	 */
	@Override
	public String handleRequest(String user, int num) {
		String name="张三";
		String result="";
		if(num<=5000)
		{
			if(user.equals(name))
			{
				result="二级处理者已处理，"+user+"验证通过。";
			}
			else
			{
				result="二级处理者已处理，"+user+"验证不通过。";
			}
		}
		else
		{
			if(getNextHandler()!=null)
			{
				return getNextHandler().handleRequest(user,num);
			}
		}
		return result;
	}

}
