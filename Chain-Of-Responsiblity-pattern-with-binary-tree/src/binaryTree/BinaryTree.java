package binaryTree;

import handlers.PurchasePower;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sss on 26/12/2017.
 */
public class BinaryTree {



    private PurchasePower purchasePowerRoot;



    public void init()
    {


        List<String> handlersSet=new ArrayList<>();
        List<PurchasePower> peopleList=new ArrayList<>();
        findAndAddClassesInPackageByFile("handlers","src/handlers",false,handlersSet);

        for (String handler:handlersSet)
        {
            if (!handler.equals("PurchasePower")) {
                try {
                    //System.out.println("p: "+handler);
                    Class dis_i = Class.forName("handlers." + handler);
                    PurchasePower item = (PurchasePower) dis_i.newInstance();
                    peopleList.add(item);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        int startPower=0;


        // sort list ASC
        Collections.sort(peopleList, new Comparator<PurchasePower>() {
            @Override
            public int compare(PurchasePower o1, PurchasePower o2) {
                return o1.getAllowable()>o2.getAllowable()?1:-1;
            }
        });


        //build a binary tree
        PurchasePower proot=peopleList.get(peopleList.size()/2);

        for (int i=0;i<peopleList.size();i++)
        {
            //System.out.println(peopleList.get(i).getAllowable());
            if (i!=peopleList.size()/2)
                buildTree(proot,peopleList.get(i));
        }

        // print by preorder

        preOrder(purchasePowerRoot);






/*  old ones

        ManagerPPower manager = new ManagerPPower();
        DirectorPPower director = new DirectorPPower();
        VicePresidentPPower vp = new VicePresidentPPower();
        PresidentPPower president = new PresidentPPower();
        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);
*/
    }

    private void buildTree(PurchasePower pp,PurchasePower current)
    {
        if (purchasePowerRoot==null)
            purchasePowerRoot=pp;

        if (current.getAllowable()<pp.getAllowable())
        {
            if (pp.getSuccessor()==null)
                pp.setSuccessor(current);
            else buildTree(pp.getSuccessor(),current);
        }
        else {

            if (pp.getSecondSuccessor()==null)
                pp.setSecondSuccessor(current);
            else buildTree(pp.getSecondSuccessor(),current);
        }

    }

    private void preOrder(PurchasePower p)
    {
        if (p!=null)
        {
            System.out.println(p.getAllowable());
            preOrder(p.getSuccessor());
            preOrder(p.getSecondSuccessor());
        }
    }



    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    private void findAndAddClassesInPackageByFile(String packageName,
                                                 String packagePath, final boolean recursive, List<String> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            // log.warn("用户定义包名 " + packageName + " 下没有任何文件");
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.java结尾的文件
            public boolean accept(File file) {
                return (recursive && file.isDirectory())
                        || (file.getName().endsWith(".java"));
            }
        });
        // 循环所有文件
        for (File file : dirfiles) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "."
                                + file.getName(), file.getAbsolutePath(), recursive,
                        classes);
            } else {
                // 如果是java类文件 去掉后面的.java 只留下类名
                String className = file.getName().substring(0,
                        file.getName().length() - 5);
                try {
                    // 添加到集合中去
                    classes.add(className);

                } catch (Exception e) {
                    // log.error("添加用户自定义视图类错误 找不到此类的.java文件");
                    e.printStackTrace();
                }
            }
        }
    }


    public PurchasePower getHead()
    {

        return purchasePowerRoot;
    }
}
