class Pair{
    public double x;
    public long n;
    public Pair(double x, long n){
        this.x = x;
        this.n = n;
    }
}
class Solution {
    public double myPow(double x, int n) {
        HashMap<Pair, Double> map = new HashMap<>();
        int sign = x < 0 && n%2!=0 ? -1:1;
        boolean frac = n < 0;
        double ans = helper(Math.abs(x), Math.abs((long) n), map);
        if(frac){
            ans = 1/ans;
        }
        return sign*ans;
    }

    public double helper(double x, long n, HashMap<Pair, Double> map){
        if(n==0) return (double) 1;
        if(n==1) return x;
        boolean odd = n%2==1;
        Pair p = new Pair(x, n/2);
        if(!map.containsKey(p)){
            map.put(p, helper(x, n/2, map));
        }
        if(odd){
            return map.get(p)*map.get(p)*x;
        }
        return map.get(p)*map.get(p);
    }
}