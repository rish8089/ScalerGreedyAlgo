package Easy;

import javax.lang.model.SourceVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnotherCoinProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine());
        AnotherCoinProblem obj=new AnotherCoinProblem();
        System.out.println(obj.solve(A));
    }
    public int solve(int A) {
        int ans=0;
        while(A>0){
            if(A<5){
                ans+=A;
                break;
            }else{
                int power=0;
                int temp=A;
                while(A>=5) {
                    A = A / 5;
                    power++;
                }
                int val=(int)Math.pow(5,power);
                ans+=temp/val;
                A=temp%val;
            }
        }
        return ans;
    }
}
