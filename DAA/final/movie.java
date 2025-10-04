import java.util.Scanner;

class Movie {
    String name;
    double rating;
    int year;
    int popularity;

    Movie(String name, double rating, int year, int popularity) {
        this.name = name;
        this.rating = rating;
        this.year = year;
        this.popularity = popularity;
    }
}

public class movie {

    // QuickSort function
    static void quickSort(Movie[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function for descending order
    static int partition(Movie[] arr, int low, int high) {
        double pivot = arr[high].rating;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].rating >= pivot) { // descending
                i++;
                Movie temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Movie temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();

        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Movie name: ");
            String name = sc.next();
            System.out.print("Rating: ");
            double rating = sc.nextDouble();
            System.out.print("Year: ");
            int year = sc.nextInt();
            System.out.print("Popularity: ");
            int popularity = sc.nextInt();
            movies[i] = new Movie(name, rating, year, popularity);
        }

        quickSort(movies, 0, movies.length - 1);

        System.out.println("\nMovies sorted by rating (high to low):");
        System.out.println("Name\tRating\tYear\tPopularity");
        for (Movie m : movies) {
            System.out.printf("%s\t%.1f\t%d\t%d\n", m.name, m.rating, m.year, m.popularity);
        }

        sc.close();
    }
}
