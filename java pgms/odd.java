public class odd {
 
        public static void main(String[] args) {
               
                //define the limit
                int limit = 50;
               
                System.out.println("Printing Odd numbers between 1 and " + limit);
               
                for(int i=1; i <= limit; i++){
                       
                        //if the number is not divisible by 2 then it is odd
                        if( i % 2 != 0){
                                System.out.print(i + " ");
                        }
                }
        }
}