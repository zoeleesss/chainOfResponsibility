/**
 * 
 */
package client;

import abstractHandler.Handler;
import concreteHandler.OneLevelHandler;
import concreteHandler.ThreeLevelHandler;
import concreteHandler.TwoLevelHandler;

/**
 * @author lw
 *
 */
public class ClientGui {
	public static void main(String[] args) {
        //先要组装责任链
        Handler h1 = new OneLevelHandler();
        Handler h2 = new TwoLevelHandler();
        Handler h3 = new ThreeLevelHandler();
        h1.setNextHandler(h2);
        h2.setNextHandler(h3);
        //开始测试
        String test1 = h1.handleRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = h1.handleRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");
        String test3 = h1.handleRequest("张三", 3000);
        System.out.println("test3 = " + test3);
        String test4 = h1.handleRequest("李四", 3000);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");       
        String test5 = h1.handleRequest("张三", 15000);
        System.out.println("test5 = " + test5);
        String test6 = h1.handleRequest("李四", 15000);
        System.out.println("test6 = " + test6);
    }

}
