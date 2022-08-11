//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Spring 2022
//
// Author:   (your name)
// Email:    (your @wisc.edu email address)
// Lecturer: (Mouna Kacem or Hobbes LeGault)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

// Add javadoc style class header here
// File Header comes here
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

   /**
    * Checks the correctness of the implementation of both addMovie() and toString() methods
    * implemented in the MovieTree class. This unit test considers at least the following scenarios.
    * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
    * string representation is an empty string "". (2) try adding one movie and then check that the
    * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
    * called on the tree returns the expected output. (3) Try adding another movie which is smaller
    * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
    * root, (5) Try adding at least two further movies such that one must be added at the left
    * subtree, and the other at the right subtree. For all the above scenarios, and more, double
    * check each time that size() method returns the expected value, the add method call returns
    * true, and that the .toString() method returns the expected string representation of the
    * contents of the binary search tree in an increasing order from the smallest to the greatest
    * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
    * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
    * did not change.
    *
    * @return true when this test verifies a correct functionality, and false otherwise
    */
   public static boolean testAddMovieToStringSize() {
      MovieTree movieTree = new MovieTree();
      Movie movie1 = new Movie(2008, 9.0, "Batman Begins");
      boolean pass = (movieTree.addMovie(movie1));
      System.out.println(pass);

      System.out.print(movieTree.size());



      return false;
   }

   /**
    * This method checks mainly for the correctness of the MovieTree.contains() method. It must
    * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
    * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
    * height 3 which contains at least 5 movies. Then, try to call contains() method to search for the
    * movie having a match at the root of the tree. (3) Then, search for a movie at the right and
    * left subtrees at different levels considering successful and unsuccessful search operations.
    * Make sure that the contains() method returns the expected output for every method call.
    *
    * @return true when this test verifies a correct functionality, and false otherwise
    */
   public static boolean testContains() {
      return false;
   }

   /**
    * Checks for the correctness of MovieTree.height() method. This test must consider several
    * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
    * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
    * MovieTree with the following structure for instance, is 4.
    *       (*)
    *     /    \
    *  (*)      (*)
    *    \     /  \
    *    (*) (*)  (*)
    *             /
    *           (*)
    *
    * @return true when this test verifies a correct functionality, and false otherwise
    */
   public static boolean testHeight() {
      return false;
   }

   /**
    * Checks for the correctness of MovieTree.getBestMovie() method.
    *
    * @return true when this test verifies a correct functionality, and false otherwise
    */
   public static boolean testGetBestMovie() {
      return false;
   }

   /**
    * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
    * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
    * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
    * list which contains all the movies satisfying the search criteria of year and rating, when called
    * on a non empty movie tree with one match, and two matches and more. Vary your search criteria
    * such that the lookup() method must check in left and right subtrees. (3) Ensures that the
    * MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie tree
    * with no search results found.
    *
    * @return true when this test verifies a correct functionality, and false otherwise
    */
   public static boolean testLookup() {
      return false;
   }

   /**
    * Calls the test methods
    *
    * @param args input arguments if any
    */
   public static void main(String[] args) {
      Movie movie1 = new Movie(2008, 9.0, "Batman Begins");
      Movie movie2 = new Movie(2008, 9.0, "The Dark Knight");
      Movie movie3 = new Movie(2008, 9.0, "The Dark Knight Rises");

      System.out.println(movie1);
      testAddMovieToStringSize();


   }

}
