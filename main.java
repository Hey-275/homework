import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        String[] Describes={"牙刷","牙膏","毛巾","脸盆","剃须刀","文化衫","背包","水杯","笔记本","钢笔"};
        Integer[] Cost = {1,3,2,4,5,6,7,4,5,5};
        ArrayList<ProductS> Products=InitProducts(Describes,Cost);
        ArrayList<User> Users = new ArrayList<User>();
        User user ;
        ProductS product ;
        Random rand = new Random();
        for (int i=0;i<100;i++){
            Users.add(new User(i));
        }

        Runnable task = () -> {
            User user1 = Users.get(rand.nextInt(100));
            ProductS product1 ;
            Integer flag = rand.nextInt(10);

            while (true){

                product1 = Products.get(flag%10);
                synchronized (product1){


                if (product1.getAmount()>0&&user1.getIntegral()>product1.getCost()){
                    user1.setIntegral(user1.getIntegral()-product1.getCost());
                    product1.setAmount(product1.getAmount()-1);
                    user1.getPurchased().put(product1,user1.getPurchased().get(product1)==null?1:user1.getPurchased().get(product1)+1);

                    break;
                }
                System.out.println(2);
                flag+=1;
            }
            }
        };
        for (int i=0;i<50000;i++){
            Thread thread = new Thread(task);
            thread.start();
        }
        Integer num=0;
        for (int i =0 ;i<100;i++){
            for (int j=0;j<10;j++){
                num+= Users.get(i).getPurchased().get(Products.get(j));
                System.out.println(Users.get(i).getPurchased().get(Products.get(j)));
            }
        }
        System.out.println(num);
        Integer kk = 0;
        for (int i=0;i<10;i++){
            // System.out.println(Products.get(i));
            System.out.println(Users.get(i));
            kk+=10000-Products.get(i).getAmount();

        }
        System.out.println(kk);

//
//        for (int i=0;i<50000;i++){
//            user = Users.get(rand.nextInt(100));
//            Integer flag = rand.nextInt(10);
//
//            while (true){
//                product = Products.get(flag%10);
//                if (product.getAmount()>0&&user.getIntegral()>product.getCost()){
//                    user.setIntegral(user.getIntegral()-product.getCost());
//                    product.setAmount(product.getAmount()-1);
//                    user.getPurchased().put(product,user.getPurchased().get(product)==null?1:user.getPurchased().get(product)+1);
//
//                    break;
//                }
//                System.out.println(2);
//                flag+=1;
//            }
//
//        }
//        Integer num=0;
//        for (int i =0 ;i<100;i++){
//            for (int j=0;j<10;j++){
//                num+= Users.get(i).getPurchased().get(Products.get(j));
//                System.out.println(Users.get(i).getPurchased().get(Products.get(j)));
//            }
//        }
//        System.out.println(num);
//        Integer kk = 0;
//        for (int i=0;i<10;i++){
//           // System.out.println(Products.get(i));
//            System.out.println(Users.get(i));
//            kk+=10000-Products.get(i).getAmount();
//
//        }
//        System.out.println(kk);
    }

    private static ArrayList<ProductS> InitProducts(String[] Describes,Integer[] Cost){
        ProductS productS;
        ArrayList<ProductS> Products=new ArrayList<ProductS>();
        for (int i=0;i<10;i++){
            productS=new ProductS();
            productS.setAmount(10000);
            productS.setCost(Cost[i]);
            productS.setId(i);
            productS.setDescribe(Describes[i]);
            Products.add(productS);
        }
        return Products;
    }
}
