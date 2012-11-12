/**
 * Created with IntelliJ IDEA.
 * User: rahuls
 * Date: 11/11/12
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class PowerFunction {

    public static double pow(double a , int b) {


        double prod=1D;
        if ( b == 0) return 1D;
        if ( a == 0 ) return 0D;
        for (int i=1; i<=b;i++)
        {
            prod=prod*a;
        }
        if (b < 0)
        return 1/prod;
        else
            return prod;
    }

    public static void main(String[] args) {
        System.out.println(" value of pow(5.3,2) is :"+ pow(5.3,2));
        System.out.println(" value of pow(5.3,2) is :"+ pow(-5.3,3));
        System.out.println(" value of pow(5.3,2) is :"+ pow(-5.3,2));
        System.out.println(" value of pow(5.3,2) is :"+ pow(-5.3,2));
    }
}
