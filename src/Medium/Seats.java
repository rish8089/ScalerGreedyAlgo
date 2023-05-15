package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class  Seats {
    private int MOD=1000000003;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        Seats obj=new Seats();
        System.out.println(obj.seats(s));
    }
    public int seats(String A) {
        ArrayList<Integer> ops=new ArrayList<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='x')
                ops.add(i);
        }
        if(ops.size()==0)
            return 0;
        long []leftSum=new long[ops.size()];
        long []rightSum=new long[ops.size()];
        for(int i=0;i<ops.size();i++){
            leftSum[i]=i-1>=0?leftSum[i-1]+ops.get(i):ops.get(i);
        }
        for(int i=ops.size()-1;i>=0;i--){
            rightSum[i]=i+1<ops.size()?rightSum[i+1]+ops.get(i):ops.get(i);
        }
        long minShifts=-1;
        for(int i=0;i<ops.size();i++){
            long shifts= (long)(i+1)*ops.get(i)-leftSum[i]- (long) i *(i+1)/2+rightSum[i]- (long) (ops.size() - i) *ops.get(i)-
                    (long) (ops.size() - i - 1) *(ops.size()-i)/2;
            if(minShifts==-1 || minShifts>shifts)
                minShifts=shifts;
        }
        return (int)(minShifts%MOD);
    }
}
