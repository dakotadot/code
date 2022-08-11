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

import java.util.ArrayList;
import java.util.NoSuchElementException;

// Add javadoc style class header here
public class MovieTree {
   private BSTNode<Movie> root; // root of this movie BST
   private int size; // size of this movie tree

   /**
    * Checks whether this binary search tree (BST) is empty
    *
    * @return true if this MovieTree is empty, false otherwise
    */
   public boolean isEmpty() {
      return this.root == null && this.size == 0;
   }

   /**
    * Returns the number of movies stored in this BST.
    *
    * @return the size of this MovieTree
    */
   public int size() {

      return this.size; // Remove this default return statement. Added to resolve compiler error
   }


   /**
    * Adds a new movie to this MovieTree
    *
    * @param newMovie a new movie to add to this BST.
    * @return true if the newMovie was successfully added to this BST, and returns false if there is
    *         a match with this movie already stored in this BST.
    */
   public boolean addMovie(Movie newMovie) {
      int year = newMovie.getYear();
      double rating = newMovie.getRating();
      String name = newMovie.getName();

      if (isEmpty()) {
         root = new BSTNode<Movie>(newMovie);
         size++;
         return true;
      } else if (contains(year, rating, name)) {
         return false;
      }
      else {
         addMovieHelper(newMovie, root);
         size++;
         return true;
      }

   }

   /**
    * Recursive helper method to add a new movie to a MovieTree rooted at current.
    *
    * @param current  The "root" of the subtree we are inserting new movie into.
    * @param newMovie The movie to be added to a BST rooted at current.
    * @return true if the newMovie was successfully added to this MovieTree, false otherwise
    */
   protected static boolean addMovieHelper(Movie newMovie, BSTNode<Movie> current) {
      if (current == null) {return false;}

      if (newMovie.compareTo(current.getData()) < 0 && current.getLeft() == null) {
         BSTNode<Movie> newNode = new BSTNode<Movie>(newMovie);
         current.setLeft(new BSTNode<Movie>(newMovie));
         return true;
      }
      if (newMovie.compareTo(current.getData()) > 0 && current.getRight() == null) {
         BSTNode<Movie> newNode = new BSTNode<Movie>(newMovie);
         current.setRight(new BSTNode<Movie>(newMovie));
         return true;
      }

      if(newMovie.compareTo(current.getData()) < 0) {
         addMovieHelper(newMovie, current.getRight());
      }
      else {
         addMovieHelper(newMovie, current.getRight());
      }


      return false; // A default return statement added to let this code compile.
   }

   /**
    * Returns a String representation of all the movies stored within this BST in the increasing
    * order, separatingd by a newline "\n". For instance
    *
    * "[(Year: 1988) (Rate: 7.0) (Name: Light Years)]" + "\n" +
    * "[(Year: 2015) (Rate: 6.5) (Name: Cinderella)]" + "\n"
    *
    * @return a String representation of all the movies stored within this BST sorted in an
    *         increasing order with respect to the result of Movie.compareTo() method (year, rating,
    *         name). Returns an empty string "" if this BST is empty.
    */
   @Override
   public String toString() {
      if (root == null) {
         return "";
      }

      return toStringHelper(root);
   }

   /**
    * Recursive helper method which returns a String representation of the BST rooted at current. An
    * example of the String representation of the contents of a MovieTree is provided in the
    * description of the above toString() method.
    *
    * @param current reference to the current movie within this BST (root of a subtree)
    * @return a String representation of all the movies stored in the sub-tree rooted at current in
    *         increasing order with respect to the result of Movie.compareTo() method (year, rating,
    *         name). Returns an empty String "" if current is null.
    */
   protected static String toStringHelper(BSTNode<Movie> current) {
      String string = "";

      // base case, reached the end of the tree
      if (current == null) {
         return string;
      }

      String left = toStringHelper(current.getLeft());
      String self = "";
      self += current.getData();
      String right = toStringHelper(current.getRight());

      string  = left + self + right;

      return string;
   }

   /**
    * Computes and returns the height of this BST, counting the number of NODES from root to the
    * deepest leaf.
    *
    * @return the height of this Binary Search Tree
    */
   public int height() {
      return heightHelper(root);
   }

   /**
    * Recursive helper method that computes the height of the subtree rooted at current counting the
    * number of nodes and NOT the number of edges from current to the deepest leaf
    *
    * @param current pointer to the current BSTNode within a MovieTree (root of a subtree)
    * @return height of the subtree rooted at current
    */
   protected static int heightHelper(BSTNode<Movie> current) {
      int heightTracker = 0;

      if (current.getLeft() == null && current.getRight() == null) {
         return heightTracker;
      }

      if (current.getLeft() != null && current.getRight() == null) {
         heightTracker++;
      }
      if (current.getLeft() == null && current.getRight() != null) {
         heightTracker++;
      }
      if (current.getLeft() != null && current.getRight() != null) {
         heightTracker++;
      }






      // TODO Complete this implementation of this method
      return 0; // remove this statement.

   }

   /**
    * Checks whether this MovieTree contains a movie given its name, production year, and rating.
    *
    * @param year   year of production of the movie to search
    * @param rating rating of the movie to search
    * @param name   name of the movie to search
    * @return true if there is a match with this movie in this BST, and false otherwise
    */
   public boolean contains(int year, double rating, String name) {
      Movie movie = new Movie(year, rating, name);
      return containsHelper(movie, root);
   }

   /**
    * Recursive helper method to search wether there is a match with a given movie in the subtree
    * rooted at current
    *
    * @param target  a reference to a movie we are searching for a match in the BST rooted at
    *                current.
    * @param current "root" of the subtree we are checking whether it contains a match to target.
    * @return true if match found and false otherwise
    */
   protected boolean containsHelper(Movie target, BSTNode<Movie> current) {

      if (current == null) {
         return false;
      }
      if (current.getData().compareTo(target) == 0) {
         return true;
      }
      if (target.compareTo(current.getData()) < 0) {
         return containsHelper(target, current.getLeft());
      }
      else {
         return containsHelper(target, current.getRight());
      }
   }


   /**
    * Gets the best (maximum) movie in this BST
    *
    * @return the best (largest) movie (the most recent, highest rated, and having the largest name)
    *         in this MovieTree, and null if this tree is empty.
    */
   public Movie getBestMovie() {
      Movie movie = new Movie(1, 2000, "No");
      double highestRating = root.getData().getRating();
      double left = 0;
      double right = 0;
      for (int i = 0; i < size; i++) {
         left = root.getData().getRating();
         right = root.getData().getRating();
         if (left > highestRating) {
            highestRating = left;
            movie = root.getData();
         }
         if (right > highestRating) {
            highestRating = right;
            movie = root.getData();
         }
      }

      return movie; // added to let this incomplete code compile
   }


   /**
    * Search for movies given the year and minimum rating as lookup key.
    *
    * @param year   production year of a movie
    * @param rating rating value of a movie
    * @return a list of movies whose year equals our lookup year key and having a rating greater or
    *         equal to a given rating.
    * @throws NoSuchElementException with a descriptive error message if there is no Movie found in
    *           this BST having the provided year and a rating greater or equal to the provided
    *           rating
    */
   public ArrayList<Movie> lookup(int year, double rating) {
      // TODO

      // call lookupHelper given the year, rating, the root of this MovieTree and an empty arrayList)

      // If no match found by the lookupHelper throw a NoSuchElementException with a descriptive error
      // message

      // else return the list of movies

      return null; // remove this statement. Added to let this code to compile without errors
   }

   /**
    * Recursive helper method to lookup the list of movies given their year of production and a
    * minimum value of rating
    *
    * @param year      the year we would like to search for a movie
    * @param rating    the minimum rating we would like to search for a movie
    * @param movieList an arraylist which stores the list of movies matching our search criteria
    *                  (exact year of production and having at least the provided rating) within the
    *                  subtree rooted at current
    * @param current   "root" of the subtree we are looking for a match to find within it.
    */
   protected void lookupHelper(int year, double rating, BSTNode<Movie> current,
                               ArrayList<Movie> movieList) {
      // TODO Complete the implementation of this method

      // TODO If the BST rooted at current is null, do nothing and return

      // TODO if the BST rooted at current is not empty, perform a pre-order traversal of the subtree
      // starting from current looking for movies satisfying our search criteria, and add each of them
      // to the movieList

   }
}
