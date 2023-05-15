package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FinishMaximumJobs {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        FinishMaximumJobs obj=new FinishMaximumJobs();
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        str=br.readLine().split(" ");
        ArrayList<Integer> B=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            B.add(Integer.parseInt(str[i]));
        System.out.println(obj.solve(A,B));
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Node> list=new ArrayList<>();
        int n=A.size();
        for(int i=0;i<n;i++)
            list.add(new Node(A.get(i),B.get(i)));
        Collections.sort(list, (nd1,nd2)->{
            return Integer.compare(nd1.end,nd2.end);
        });
        int cnt=1;
        int pos=0;
        for(int i=1;i<n;i++){
            if(list.get(i).start>=list.get(pos).end){
                cnt++;
                pos=i;
            }
        }
        return cnt;
    }
    class Node{
        int start;
        int end;
        Node(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
}
