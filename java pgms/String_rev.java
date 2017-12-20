public class String_rev {
public static void main(String[] args) {
    String str="Karan Rajput";
    int ln=str.length();
    for (int i = ln; i > 0; i--) {
        System.out.print(str.charAt(i-1));
        //output - tupjaR naraK
    }
}
}
//another way for recursive reverse

