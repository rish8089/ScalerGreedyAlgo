package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BinaryStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BinaryStrings obj=new BinaryStrings();
        int B=Integer.parseInt(br.readLine());
        System.out.println(obj.solve(br.readLine(),B));
    }
    public int solve(String A, int B) {
        ArrayList<Integer> toggles=new ArrayList<>();
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            int noOfToggles=getNoOfToggles(toggles,i);
            c=noOfToggles%2==0?c:(char)((c-'0'+1)%2+'0');
            if(c=='0'){
                if(A.length()-i<B)
                    return -1;
                toggles.add(i+B-1);
            }
        }
        return toggles.size();
    }
    private int getNoOfToggles(ArrayList<Integer> list, int pos){
        int u=0;
        int v=list.size()-1;
        int ans=-1;
        while(u<=v){
            int mid=(u+v)/2;
            if(pos<=list.get(mid)){
                ans=mid;
                v=mid-1;
            }else{
                u=mid+1;
            }
        }
        return ans==-1?0:list.size()-ans;
    }
}
