package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistributeCandy2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        DistributeCandy2 obj=new DistributeCandy2();
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        System.out.println(obj.candy(A));
    }
    public int candy(ArrayList<Integer> A) {
        ArrayList<Integer> candies=new ArrayList<>();
        int n=A.size();
        for(int i=0;i<n;i++)
            candies.add(1);
        for(int i=0;i<n-1;i++){
            if(A.get(i)<A.get(i+1) && candies.get(i+1)<=candies.get(i))
                candies.set(i+1, candies.get(i)+1);
        }
        for(int i=n-1;i>0;i--){
            if(A.get(i-1)>A.get(i) && candies.get(i-1)<=candies.get(i))
                candies.set(i-1,candies.get(i)+1);
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=candies.get(i);
        }
        return sum;
    }
}
