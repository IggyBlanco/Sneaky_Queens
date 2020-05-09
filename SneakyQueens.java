// Iggy Blanco

import java.util.*;
import java.io.*;

public class SneakyQueens
{
  public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize)
  {

    // Initialized 4 HashMaps in which i store in the values during iteration.
    HashMap<Integer, Integer> columnMap = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> diagonalMap = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> antiDiagonalMap = new HashMap<Integer, Integer>();

    // Iterates through the arrayList passed in from the test cases.
    for (int i = 0; i < coordinateStrings.size(); i++)
    {
      String str = coordinateStrings.get(i);
      int j = 0; // iterates through chars
      int xCol = 0; // column number
      int yRow = 0; // row number
      int mSlope = 0; // diagonal column number
      int nSlope = 0; // anti-diagonal row number

      // These queues are filled with char values that are
      // later unloaded in the horners function.
      Queue<Integer> colQ = new LinkedList<Integer>();
      Queue<Integer> rowQ = new LinkedList<Integer>();

      // Singles out the chars in the string, in order to convert.
      for (j = 0; j < str.length(); j++)
      {
        char ch = str.charAt(j);
        int ascii = (int) ch; // holds ascii value
        placeValue(ascii, colQ, rowQ, j); // determines value type
      }

      // With horners, i extract the real values.
      xCol = horner(colQ, 26);
      yRow = horner(rowQ, 10);

      // Simple functions to return diagonal coordinates.
      mSlope = getDiagonal(xCol, yRow);
      nSlope = getAntiDiagonal(xCol, yRow);

      // If statements to check if the hashmaps contain
      // any of the values that are about to be inputted.
      // Collision detection.
      if (columnMap.containsKey(xCol) == true)
      {
        return false;
      }
      else if (rowMap.containsKey(yRow) == true)
      {
        return false;
      }
      else if (diagonalMap.containsKey(mSlope) == true)
      {
        return false;
      }
      else if (antiDiagonalMap.containsKey(nSlope) == true)
      {
        return false;
      }
      else
      {
        columnMap.put(xCol, i); // Hash inputs
        rowMap.put(yRow, i);
        diagonalMap.put(mSlope, i);
        antiDiagonalMap.put(nSlope, i);
      }
    }
    return true; // LONG LIVE THE QUEEN
  }

  // Determines if the ascii value is a letter or a number
  // before adjusting its value.
  public static void placeValue(int ascii, Queue<Integer> colQ, Queue<Integer> rowQ, int j)
  {
    int n = 0;
    if (ascii < 95)
    {
      n = ascii - 48; // ascii is number
      rowQ.add(n);
    }
    else if (ascii > 95) // ascii is letter
    {
      n = ascii - 96;
      colQ.add(n);
    }
  }

  // By adding the column and row, we get what could be
  // represented as a diagonal column.
  public static int getDiagonal(int xCol, int yRow)
  {
    int diag = xCol + yRow;
    return diag;
  }

  // With the values we get from subtracting the row
  // and the column, we represent a diagonal row
  public static int getAntiDiagonal(int xCol, int yRow)
  {
    int aDiag = xCol - yRow;
    return aDiag;
  }

  // This is the horner's rule code from class that we use to
  // retrieve the finalized column and row numbers. I altered
  // it slightly to adapt with my use of queues.
  public static int horner(Queue<Integer> q, int k)
  {
    int n = q.size();
    int retVal = 0;
    for (int i = n - 1; i >= 0; i--)
    {
      retVal *= k;
      retVal += q.remove(); // only difference
    }
    return retVal;
  }

  // My re-introduction to object oriented. I took oop
  // spring 2018 and it was not a very demanding course.
  // Nonetheless, the project was fun and now that i'm more
  // comfortable with java again, i'll be fine.
  public static double difficultyRating()
  {
    double diff = 4.0;
    return diff;
  }

  public static double hoursSpent()
  {
    double time = 20;
    return time;
  }
}
