
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
 * @Test
 */

public class MovieRatingsTest
{
   public static void main(String args[])
   {
      String[] movies = {"Gravity", "12 Years a Slave", "Spaceballs"};
      String[] reviewers = {"Jen", "Bino", "Sophia"};
      MovieRatings ratings = new MovieRatings(reviewers, movies);
      
      //give some values for the ratings
      for(int i = 0; i<reviewers.length; i++)
         for(int j=0; j<movies.length; j++)
            ratings.setRating(i, j, i+j);
            
      ratings.printReviewerRatings(0); //prints 0, 1, 2 for Gravity
      ratings.printReviewerRatings(1); //prints 1, 2, 3 for 12 Years a Slave
      ratings.printReviewerRatings(2); //prints 2, 3, 4 for Spaceballs
      
      ratings.printMovieRatings(0);  //prints 0, 1, 2 for Jen
      ratings.printMovieRatings(1);  //prints 1, 2, 3 for Bino
      ratings.printMovieRatings(2);  //prints 2, 3, 4, for Sophia
      
      System.out.println("Index for 12 Years a Slave: " + ratings.getMovieIndex("12 Years a Slave")); //prints 1
      System.out.println("Index for Bino: " + ratings.getReviewerIndex("Bino")); //prints 1
      
      System.out.println("Average Rating: " + ratings.getAvgRating()); //prints 
      System.out.println("Average Rating by Jen: " + ratings.getAvgRatingsbyReviewer(0)); //prints 1.0
      System.out.println("Average Rating for Spaceballs: " + ratings.getAvgRatingsbyMovie(2)); //prints 3.0
      
   }
}
