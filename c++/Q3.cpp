#include <bits/stdc++.h>
using namespace std;

#define MOD 1000000007
#define INF  2000000000
#define ll long long
#define ld long double
#define vi vector<int>
#define p pair<int, int>
#define fi first
#define se second
#define pb push_back
#define mp make_pair

#define INIT ios::sync_with_stdio(false);cin.tie(0);
#define VAR(type, ...)type __VA_ARGS__;MACRO_VAR_Scan(__VA_ARGS__);
template<typename T> void MACRO_VAR_Scan(T& t) { cin >> t; }
template<typename First, typename...Rest>void MACRO_VAR_Scan(First& first, Rest&...rest) { std::cin >> first; MACRO_VAR_Scan(rest...); }
#define VEC(type, c, n) vector<type> c(n);for(auto& i:c)cin>>i;
#define MAT(type, c, m, n) vector<vector<type>> c(m, vector<type>(n));for(auto& r:c)for(auto& i:r)cin>>i;

#define BR cout << "\n";
#define SP cout << " ";
#define ENDL cout<<endl;
#define OUT(d) cout<<(d);
#define OUTL(d) cout<<(d); ENDL;

#define REP(i, n) for(int i = 0;i < n; i++)
#define RREP(i, n) for(int i=n-1;i>=0;--i)
#define FOR(i, m, n) for(int i = m;i < n; i++)
#define RFOR(i, a, b) for(int i=(b)-1;i>=(a);--i)
#define ALL(a) (a).begin(),(a).end()
#define IN(n, a, b) ((a)<=(n)&&(n)<=(b))

signed main(){
    VAR(int, n, m);
    int v[25], w[25], dp[256];
    REP(i, m+1) dp[i] = 0;
    REP(i, n) REP(j, n){
        cin >> v[i*n+j];
        w[i*n+j]=(i+1)*(j+1);
    }
    FOR(i, 1, n*n+1) RREP(j, m+1) if(j - w[i-1] >= 0) dp[j] = max(dp[j], dp[j - w[i-1]] + v[i - 1]);
    
    OUTL(dp[m]);
    return 0;
}