public class Test {
public static void main(String args[]){
    java.util.Date dt=new java.util.Date();
    System.out.println(dt);
    long ts=dt.getTime();
    System.out.println(ts);
    java.sql.Date dt1=new java.sql.Date(ts);
    System.out.println(dt1);
}    
}
