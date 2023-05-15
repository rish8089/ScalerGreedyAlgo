package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DistributeCandy {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        DistributeCandy obj=new DistributeCandy();
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
        PriorityQueue<PQNode> pq=new PriorityQueue<>((nd1,nd2)->{
            return Integer.compare(nd1.val,nd2.val);
        });
        for(int i=0;i<n;i++){
            pq.add(new PQNode(A.get(i),i));
        }
        while(!pq.isEmpty()){
            PQNode nd=pq.poll();
            int pos=nd.pos;
            while(pos-1>=0 && A.get(pos-1)>A.get(pos) && candies.get(pos-1)<=candies.get(pos)){
                candies.set(pos-1,candies.get(pos)+1);
                pos--;
            }
            while(pos+1<n && A.get(pos+1)>A.get(pos) && candies.get(pos+1)<=candies.get(pos)){
                candies.set(pos+1,candies.get(pos)+1);
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=candies.get(i);
        }
        return sum;
    }
    class PQNode{
        int val;
        int pos;
        PQNode(int val, int pos){
            this.val=val;
            this.pos=pos;
        }
    }
}
