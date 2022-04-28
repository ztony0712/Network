import java.util.Scanner;

public  class  test {
    public  static  void  main(String[] args) {
        Scanner in =  new Scanner(System.in);
        System.out.println( "What's your name?" );
        String name = in.nextLine(); //读取换行符为间隔的
        System.out.println( "Hello " +name+ "." );
        System.out.println( "What's your name?" );
        System.out.println( "Hello " +in.next()+in.next()+ "." );    //读取空格为间隔的
        System.out.println( "How old are you?" );
        int  age = in.nextInt();  //读取数字
        System.out.println( "Are you  " +age+ "?" );
    }
}
