#include <bits/stdc++.h>
Using namespace std;

Void dijkstra(int source, vector<vector<pair<int,int>>> &graph, vector<int> &dist) {
    Int V = graph.size();
    Dist.assign(V, INT_MAX);
    Dist[source] = 0;

    Priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    Pq.push({0, source});

    While (!pq.empty()) {
        Int u = pq.top().second;
        Int d = pq.top().first;
        Pq.pop();

        If (d > dist[u]) continue;

        For (auto &edge : graph[u]) {
            Int v = edge.first;
            Int w = edge.second;

            If (dist[v] > dist[u] + w) {
                Dist[v] = dist[u] + w;
                Pq.push({dist[v], v});
            }
        }
    }
}

Int main() {
    Int V, E;
    Cout << “Enter number of intersections (vertices): “;
    Cin >> V;
    Cout << “Enter number of roads (edges): “;
    Cin >> E;

    Vector<vector<pair<int,int>>> graph(V);  

    Cout << “Enter edges (u v w):\n”;
    For (int I = 0; I < E; i++) {
        Int u, v, w;
        Cin >> u >> v >> w;
       
        u--; 
        v--;
        graph[u].push_back({v, w});
        graph[v].push_back({u, w}); // undirected graph
    }

    Int source;
    Cout << “Enter passenger start location (source): “;
    Cin >> source;
    Source--; // convert to 0-based

    Int A;
    Cout << “Enter number of airports: “;
    Cin >> A;
    Vector<int> airports(A);
    Cout << “Enter airport nodes: “;
    For (int I = 0; I < A; i++) {
        Cin >> airports[i];
        Airports[i]--; // convert to 0-based
    }

    Vector<int> dist;
    Dijkstra(source, graph, dist);

    Int minTime = INT_MAX, nearestAirport = -1;
    For (int a : airports) {
        If (dist[a] < minTime) {
            minTime = dist[a];
            nearestAirport = a;
        }
    }

    If (nearestAirport == -1)
        Cout << “No airport reachable.\n”;
    Else

    Cout << “Nearest airport is at node “ << (nearestAirport + 1)
             << “ with travel time “ << minTime << “ minutes.\n”;

    Return 0;
}
