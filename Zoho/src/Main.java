import java.util.*;
public class Main {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        result.addAll(map.values());
        return result;
    }
    public static void main(String[] args) {


//        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of strings");
        int n=sc.nextInt();
        String[] strs = new String[n];
        System.out.println("Enter the strings");
        for(int i=0;i<n;i++){
            strs[i]=sc.next();
        }

        List<List<String>> result = groupAnagrams(strs);

        result.sort((a,b) -> a.size() - b.size());
        System.out.println(result);



    }
}