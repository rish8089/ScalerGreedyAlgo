package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TheShipCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []AB=br.readLine().split(" ");
        int A=Integer.parseInt(AB[0]);
        int B=Integer.parseInt(AB[1]);
        String []str=br.readLine().split(" ");
        ArrayList<Integer> C=new ArrayList<>();
        for(int i=0;i<B;i++)
            C.add(Integer.parseInt(str[i]));
        TheShipCompany obj=new TheShipCompany();
        System.out.println(obj.solve(A,B,C));
    }
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());
        pq1.addAll(C);
        //min value
        int minMoney=0;
        for(int i=0;i<A;i++){
            int cost= pq1.poll();
            minMoney+=cost;
            if(cost-1>0)
                pq1.add(cost-1);
        }
        pq2.addAll(C);
        int maxMoney=0;
        for(int i=0;i<A;i++){
            int cost=pq2.poll();
            maxMoney+=cost;
            if(cost-1>0)
                pq2.add(cost-1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(maxMoney);
        list.add(minMoney);
        return list;
    }
}
