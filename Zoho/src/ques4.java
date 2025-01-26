import java.util.*;
public class ques4 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        String version1=s.next();
        String version2=s.next();
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int i=0;
        while(i<v1.length || i<v2.length){
           int num1=0;
           if(i<v1.length){
               num1=Integer.parseInt(v1[i]);
           }
           else{
               num1=0;
           }
            int num2=0;

            if(i<v2.length){
                num2=Integer.parseInt(v2[i]);
            }
            else{
                num2=0;
            }
            if(num1>num2){
                System.out.println(1);
                return;
            }
            else if(num1<num2){
                System.out.println(-1);
                return;
            }
            i++;
        }
        System.out.println(0);

    }
}
