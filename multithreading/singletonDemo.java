class SingleObject {
    String msg;
    private static SingleObject instance = new SingleObject("\nHello World....!!!!\n");

    private SingleObject(String msg)
    {
        this.msg = msg;
    }

    public static SingleObject getInstance(){
        return instance;
    }

    public void display(){
        System.out.println( msg );
    }
}
public class singletonDemo {
   public static void main(String[] args) {

      SingleObject object = SingleObject.getInstance();

      object.display();
   }
}