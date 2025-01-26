import java.util.*;
public class ques3 {
    public static void sorting(List<Integer> list){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)>list.get(j)){
                    int temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }


    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> even =new ArrayList<>();
       List<Integer>odd=new ArrayList<>();
        int e=0,o=0;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                even.add(arr[i]);
            }
            else{
                odd.add(arr[i]);
            }
        }

        sorting(even);
        sorting(odd);
        int j=0,k=odd.size()-1;

        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                System.out.print(even.get(j++)+" ");
            }
            else{
                System.out.print(odd.get(k--)+" ");

            }
        }

    }
}
