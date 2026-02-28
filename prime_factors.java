public class Solution{
    public List<Integer> primeFactors(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
                ans.add(i);
                while(n%i == 0){
                    n /= i;
                }
            }
        }
        if(n!=1) ans.add(n);
        return ans;
    }
}