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
#define OUT(d) cout<<d;
#define OUTL(d) cout<<d; ENDL;
 
#define REP(i, n) for(int i = 0;i < n; i++)
#define RREP(i, n) for(int i=n-1;i>=0;--i)
#define FOR(i, m, n) for(int i = m;i < n; i++)
#define RFOR(i, a, b) for(int i=(b)-1;i>=(a);--i)
#define ALL(a) (a).begin(),(a).end()
#define IN(n, a, b) (a)<=(n)&&(n)<=(b)
 
signed main(){
    INIT;
    string s;
    getline(cin, s);
    for(char a: s){
        if(IN(a, 'a', 'z')){string t(1, toupper(a)); OUT(t)}
        else if(IN(a, 'A', 'Z')){string t(1, tolower(a)); OUT(t)}
        else OUT(a)
    }
    ENDL
    return 0;
}