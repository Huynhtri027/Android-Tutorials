public class Model_Movie {
    String movieName;
    int movieYear;

    public Model_Movie(String movieName, int movieYear) {
        this.movieName = movieName;
        this.movieYear = movieYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }
}
