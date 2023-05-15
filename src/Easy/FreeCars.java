package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class FreeCars {
    private int MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        FreeCars obj=new FreeCars();
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
        int n=A.size();
        ArrayList<Node> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new Node(A.get(i),B.get(i)));
        Collections.sort(list, (nd1,nd2)->{
            return Integer.compare(nd1.time,nd2.time);
        });
        int maxTime=list.get(n-1).time;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int currTime=maxTime;
        int profit=0;
        for(int i=n-1;i>=0;i--){
            pq.add(list.get(i).profit);
            while(i-1>=0 && list.get(i).time==list.get(i-1).time){
                pq.add(list.get(i-1).profit);
                i--;
            }
            int nextTime=i-1>=0?list.get(i-1).time:0;
            while(currTime>nextTime && !pq.isEmpty()){
                profit=(profit+pq.poll())%MOD;
                currTime--;
            }
            currTime=nextTime;
        }
        return profit;
    }
    class Node{
        int time;
        int profit;
        Node(int time, int profit){
            this.time=time;
            this.profit=profit;
        }
    }
}
