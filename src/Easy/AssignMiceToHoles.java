package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> A=new ArrayList<>();
        String []str=br.readLine().split(" ");
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        str=br.readLine().split(" ");
        ArrayList<Integer> B=new ArrayList<>();
        for(int i=0;i<n;i++)
            B.add(Integer.parseInt(str[i]));
        AssignMiceToHoles obj=new AssignMiceToHoles();
        System.out.println(obj.mice(A,B));
    }
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n=A.size();
        Collections.sort(A);
        Collections.sort(B);
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,Math.abs(A.get(i)-B.get(i)));
        }
        return ans;
    }
}
