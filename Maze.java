import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.LinkedList;
import java.util.Queue;

public class Maze
{
  public int shortestPath(char[][] maze)
  {
      int height = maze.length;
      int width = maze[0].length;


      // 0 = Position X, 1 = Position Y, 2 = DistanceFromStart
      Deque<ArrayList> queue = new ArrayDeque();
      //En queue af Nodes, som indeholder de 3 værdier.

      //Start position:
    ArrayList<Integer> starterNode = new ArrayList<>();
    starterNode.add(1);
    starterNode.add(1);
    starterNode.add(0);

    queue.push(starterNode);

    //Slut position:
    ArrayList<Integer> Destination = new ArrayList<>();
    Destination.add(height - 2);
    Destination.add(width - 2);



    while(!(queue.isEmpty()))
    {

      // Får information fra den forreste node i queue
      int nodePosY = (int) queue.peek().get(0);
      int nodePosX = (int) queue.peek().get(1);
      int nodeDistancetoStart = (int) queue.peek().get(2);
      // Fjerner forreste node
      queue.pop();

      if (nodePosX == Destination.get(1) && nodePosY == Destination.get(0))
      {
        return nodeDistancetoStart;
      }

      nodeDistancetoStart++;

      //Laver ArrayList som skal indsættes i queue
      ArrayList<Integer> nodeToAdd = new ArrayList<>();

      if (maze[nodePosY-1][nodePosX] == '.')
      {
        nodeToAdd.add(nodePosY-1);
        nodeToAdd.add(nodePosX);
        nodeToAdd.add(nodeDistancetoStart);
        queue.push(nodeToAdd);
        maze[nodePosY-1][nodePosX] = 'o';
      }

      if (maze[nodePosY+1][nodePosX] == '.')
      {
        nodeToAdd.add(nodePosY+1);
        nodeToAdd.add(nodePosX);
        nodeToAdd.add(nodeDistancetoStart);
        queue.push(nodeToAdd);
        maze[nodePosY+1][nodePosX] = 'o';
      }

      if (maze[nodePosY][nodePosX+1] == '.')
      {
        nodeToAdd.add(nodePosY);
        nodeToAdd.add(nodePosX+1);
        nodeToAdd.add(nodeDistancetoStart);
        queue.push(nodeToAdd);
        maze[nodePosY][nodePosX+1] = 'o';
      }

      if (maze[nodePosY][nodePosX-1] == '.')
      {
        nodeToAdd.add(nodePosY);
        nodeToAdd.add(nodePosX-1);
        nodeToAdd.add(nodeDistancetoStart);
        queue.push(nodeToAdd);
        maze[nodePosY][nodePosX-1] = 'o';
      }

    }
      return Integer.MAX_VALUE;
  }
}
