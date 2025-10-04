from collections import deque

# Sample graph using adjacency list
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F'],
    'F': []
}

# -------------------------------
# Breadth-First Search (BFS)
# -------------------------------
def bfs(graph, start):
    visited = set()
    queue = deque([start])

    print("BFS Traversal:", end=" ")
    while queue:
        node = queue.popleft()
        if node not in visited:
            print(node, end=" ")
            visited.add(node)
            # Add all unvisited neighbors to the queue
            for neighbor in graph[node]:
                if neighbor not in visited:
                    queue.append(neighbor)
    print()

# -------------------------------
# Depth-First Search (DFS)
# -------------------------------
def dfs(graph, node, visited=None):
    if visited is None:
        visited = set()

    if node not in visited:
        print(node, end=" ")
        visited.add(node)
        for neighbor in graph[node]:
            dfs(graph, neighbor, visited)

# -------------------------------
# Main Program
# -------------------------------
if __name__ == "__main__":
    print("Graph:", graph)

    # Run BFS from node 'A'
    bfs(graph, 'A')

    # Run DFS from node 'A'
    print("DFS Traversal:", end=" ")
    dfs(graph, 'A')
    print()
