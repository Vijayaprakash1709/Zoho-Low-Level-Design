
import java.util.*;
public class ques5 {
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int mat[][]= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=s.nextInt();
            }
        }
        int ans[]=new int[n*m];
        int k=0;
        int i=0;
        int j=0;
        int dir=1;
        while(k<n*m){
            ans[k]=mat[i][j];
            k++;
            if(dir==1){
                if(j==m-1){
                    i++;
                    dir=-1;
                }
                else if(i==0){
                    j++;
                    dir=-1;
                }
                else{
                    i--;
                    j++;
                }
            }
            else{
                if(i==n-1){
                    j++;
                    dir=1;
                }
                else if(j==0){
                    i++;
                    dir=1;
                }
                else{
                    i++;
                    j--;
                }
            }
        }
        for(i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

}

