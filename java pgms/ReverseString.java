import java.util.ArrayDeque;
import java.util.Deque;



public class ReverseString {

public static void main(String [] args) {

	/*   String s = "reverse string" ;
    String b = "";

            for (int i = 0; i < s.length(); i++ ){
                 b= b + s.substring(s.length()-1-i, s.length()-i);

                 }

             System.out.println(b);
}
}
*/
}
public static String reverseWords(String input) {
    Deque<String> words = new ArrayDeque<>();
    for (String word: input.split(" ")) {
        if (!word.isEmpty()) {
            words.addFirst(word);
        }
    }
    StringBuilder result = new StringBuilder();
    while (!words.isEmpty()) {
        result.append(words.removeFirst());
        if (!words.isEmpty()) {
            result.append(" ");
        }
    }
    return result.toString();
}
}