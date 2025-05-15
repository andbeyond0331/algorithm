#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;
 
int n, m, t, a[101], s, k, d[101][501];
vector<int> v[101];
 
int dfs(int x, int c) {
    if (d[x][c] != -1) return d[x][c];
    if (!c) return a[x];
    d[x][c] = 2e9;
    for (auto i : v[x]) d[x][c] = min(d[x][c], dfs(i, c - 1));
    return d[x][c];
}
 
int main() {
    memset(d, -1, sizeof(d));
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    while (m--) {
        int b, c;
        scanf("%d%d", &b, &c);
        v[b].push_back(c);
        v[c].push_back(b);
    }
    scanf("%d", &t);
    while (t--) {
        scanf("%d%d", &s, &k);
        // s위치에 간선이 존재하지 않는다면 k(>=1)번 움직이는게 불가능하다
        printf("%d\n", v[s].size() ? dfs(s, k) : -1);
    }
    return 0;
}