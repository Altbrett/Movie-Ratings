
/**
 * Create a program to store and process movie ratings.
 * Use a 2D array to store ratings by different reviewers 
 * for different movies. Each row represents a different movie 
 * and each column represents a different reviewer. 
 * There will also be two separate arrays to store the names of movies
 * and the names of the reviewers. You may use the attached test program.
 *
 * @Brett Althoff
 * @1.0 02/22/2020
 */

public class MovieRatings {

   private String[] reviewers;
   private String[] movies;
   private double[][] ratings;
   
  /**
   * MovieRatings()
   * Constructor for the class
   * One parameter is an array of reviewers names
   * One parameter is an array of movie names
   * Description: set the parameters equal to the private data members 
   * for the movies and reviewers; initialize the 2D ratings array based on
   * the size of the reviewers array (rows) and the size of the movies array 
   * (columns)
   * 
   * @param reviewers establishing the reviewers
   * @param movies establishing the movies
   */
   public MovieRatings(String[] reviewers, String[] movies) {
       this.reviewers = reviewers;
       this.movies = movies;
       ratings = new double[reviewers.length][movies.length];
   }

   /**
    * getAvgRating()
    * Returns a double value representing the average rating
    * Description: Find the average rating for all movies and 
    * all reviewers (i.e. all data in the table)
    * 
    * @param total setting total ratings to 0
    * @return calculates the average rating for movie
    */
   public double getAvgRating(){
       double total = 0;
       for(int i=0;i<ratings.length;i++){
           for(int j=0;j<ratings[i].length;j++){
               total = total+ratings[i][j];
           }
       }
       return total/(reviewers.length*movies.length);
   }
   
   /**
   * getAvgRatingsbyMovie()
   * One parameter, the index of the movie to find all the reviews for
   * Returns a double value representing the average rating
   * Description: Find the average rating for a single movie 
   * (i.e. one column representing all the reviewers scores for that one movie)
   * 
   * @return calculates average by movie taken into account reviews array length
   */  
   public double getAvgRatingsbyMovie(int index){
       double total = 0;
      
       if(index<=0 || index>movies.length){
           System.out.println("Invalid Input");
       }
       else{
           for(int i=0;i<reviewers.length;i++){
               total =total+ratings[i][index-1];
           }
       }
       return total/reviewers.length;
   }

   /**
    * getAvgRatingsbyReviewer()
    * One parameter, the index of the reviewer to find all the reviews for
    * Returns a double value representing the average rating
    * Description: Find the average rating for a single reviewer 
    * (i.e. one row representing all the movies for that one reviewer)
    * 
    * @return calculates average rating based on reviewer
    * taking movie array length into account
    */
   public double getAvgRatingsbyReviewer(int index){
       double total = 0;
      
       if(index<=0 || index>reviewers.length){
           System.out.println("Invalid Input");
       }
       else{
           for(int i=0;i<movies.length;i++){
               total =total+ratings[index-1][i];
           }
       }
       return total/movies.length;
   }
   
   /**
    * getMovieIndex()
    * One parameter, the name of the movie
    * Returns an integer representing the index number of that movie
    * Description: Searches the movies array to find the index location 
    * for that movie. This can then be used to find the ratings for that movie
    * in the ratings 2D array
    * 
    * @return calculates index for movie
    */
   public int getMovieIndex(String movieName){
       for(int i=0;i<movies.length;i++){
           if(movieName.equalsIgnoreCase(movies[i])){
               return i+1;
           }
       }
       return 0;
   }
   
   /**
    * getReviewerIndex()
    * One parameter, the name of the reviewer
    * Returns an integer representing the index number of that reviewer
    * Description: Searches the reviewers array to find the index location 
    * for that reviewer. This can then be used to find the ratings for that
    * reviewer in the ratings 2D array
    * 
    * @return grabs the reviewer index
    */
   public int getReviewerIndex(String reviewerName){
       for(int i=0;i<reviewers.length;i++){
           if(reviewerName.equalsIgnoreCase(reviewers[i])){
               return i+1;
           }
       }
       return 0;
   }
   
   /**
    * setRating()
    * One parameter each for the movie index, for the reviewer index and for
    * the rating to store
    * Description: the reviewer index specifies the row, the movie index
    * specifies the column and the rating is the value to store in that cell
    * 
    * Sets the rating accordingly
    */
   public void setRating(int movieIndex, int reviewerIndex, double rating){
       ratings[reviewerIndex-1][movieIndex-1] = rating;
   }
   
   /**
   * printMovieRatings()
   * One parameter that represents the index of the movie name and the 
   * movie ratings
   * Description: prints the movie name and the ratings to System.out
   * Example: "The Lego Movie: 5, 6, 2, 7, 8"
   * 
   */
   public void printMovieRatings(int movieIndex){
       System.out.print("\n"+movies[movieIndex-1]+": ");
       for(int i=0;i<reviewers.length;i++){
           System.out.print(ratings[i][movieIndex-1]+", ");
       }
   }

   /**
   * printReviewerRatings()
   * One parameter that represents the index of the reviewers name 
   * and their movie ratings
   * Description: prints the reviewer name and the ratings to System.out
   * Example: "Roger Ebert: 4, 2, 8, 9"
   * 
   */
   public void printReviewerRatings(int reviewerIndex){
       System.out.print("\n"+reviewers[reviewerIndex-1]+": ");
       for(int i=0;i<movies.length;i++){
           System.out.print(ratings[reviewerIndex-1][i]+", ");
       }
   }
   
   /**
    * Method to go through and print all the results
    * 
    */
   
   public void printAll(){
       for(int i=0;i<reviewers.length;i++){
           for(int j=0;j<movies.length;j++){
               System.out.print(ratings[i][j]);
           }
       System.out.println();
       }
   }
   
   /**
    * Main Method
    */
   public static void main(String[] args) {
      
       String[] reviewers = {"a","b","c"};
       String[] movies = {"movie-P","movie-Q"};
       MovieRatings mr = new MovieRatings(reviewers,movies);
      
       mr.setRating(mr.getMovieIndex("movie-P"), mr.getReviewerIndex("a"), 2);
       mr.setRating(mr.getMovieIndex("movie-P"), mr.getReviewerIndex("b"), 3);
       mr.setRating(mr.getMovieIndex("movie-P"), mr.getReviewerIndex("c"), 5);
      
       mr.setRating(mr.getMovieIndex("movie-Q"), mr.getReviewerIndex("a"), 3);
       mr.setRating(mr.getMovieIndex("movie-Q"), mr.getReviewerIndex("b"), 4.0);
       mr.setRating(mr.getMovieIndex("movie-Q"), mr.getReviewerIndex("c"), 2);
      
       //mr.printAll();
       System.out.println("movie-Q avg raitngs: "+mr.getAvgRatingsbyMovie(mr.getMovieIndex("movie-Q")));
       System.out.println("Reviewwer b ratings :"+mr.getAvgRatingsbyReviewer(mr.getReviewerIndex("b")));
      
       mr.printMovieRatings(mr.getMovieIndex("movie-P"));
       mr.printReviewerRatings(mr.getReviewerIndex("a"));
   }

}