#include <bits/stdc++.h>
using namespace std;

struct Movie {
    string name;
    double rating;
    int year, popularity;
};

int partition(vector<Movie>& arr, int low, int high) {
    double pivot = arr[high].rating;
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j].rating >= pivot) { // descending order
            swap(arr[++i], arr[j]);
        }
    }
    swap(arr[i+1], arr[high]);
    return i+1;
}

void quickSort(vector<Movie>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    int n; cin >> n;
    vector<Movie> movies(n);
    for (int i = 0; i < n; i++)
        cin >> movies[i].name >> movies[i].rating >> movies[i].year >> movies[i].popularity;

    quickSort(movies, 0, n - 1);

    for (auto &m : movies)
        cout << m.name << " " << m.rating << " " << m.year << " " << m.popularity << "\n";
}
