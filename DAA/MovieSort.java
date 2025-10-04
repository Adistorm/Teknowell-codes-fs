import java.util.*;

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

class MovieSort {  
     // ✅ Class name matches file name
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double rating = sc.nextDouble();
            int year = sc.nextInt();
            int popularity = sc.nextInt();
            movies.add(new Movie(name, rating, year, popularity));
        }

        // Sort by rating in descending order
        movies.sort((a, b) -> Double.compare(b.rating, a.rating));

        // Print sorted movies
        for (Movie m : movies) {
            System.out.println(m.name + " " + m.rating + " " + m.year + " " + m.popularity);
        }

        sc.close();
    }
}

