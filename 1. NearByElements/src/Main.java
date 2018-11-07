import java.util.Arrays;

public class Main {
    public static void main (String [] args){
        NearByElement nearByElement = new NearByElement();
        nearByElement.nearby(0,6,5);
        nearByElement.nearby(0,2,2); //would result: [2, 0, 1241, 12]
        nearByElement.nearby(1,0,1); //would result: [3]
        nearByElement.nearby(1,3,5); //would result: [1, 3, 5]

    }
}
