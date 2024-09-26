import java.util.Scanner;

class Queue {
    int start;
    int end;
    int size; // Maximum size of the queue
    int numElements;
    int queue[][]; // Array that stores the coordinates of the point

    // Constructor to initialize the queue with a specific size
    public Queue(int size) {
        start = end = -1; // Initialize start and end as -1 to indicate the queue is empty
        this.size = size; // Maximum size of the queue passed as an argument when a queue is created
        queue = new int[this.size][2]; // Create the array to store the coordinates of points to be processed
        numElements = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return numElements == 0;
    }

    // Method to add a new point to the queue
    public void enqueue(int[] point) {
        // Check if the queue is not full before adding a new item
        if (!isFull()) {
            // If start is -1, change to 0 to indicate that the queue has one element
            if (start == -1) {
                start = 0;
            }
            // Increment end to indicate where the next element should be inserted
            end++;
            queue[end] = point; // Store the point's coordinates at the end position of the queue array
            numElements++;
        }
    }

    // Method to remove a point from the queue
    public int[] dequeue() {
        // Check if the queue is not empty
        if (!isEmpty()) {
            // Get the point at the start position of the queue and store the coordinates in removedPoint
            int[] removedPoint = queue[start];
            start++; // Move start to point to the next point in the queue
            numElements--;
            return removedPoint; // Return removedPoint with the coordinates of the point
        }
        return null;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return numElements == size;
    }
}

public class FloodFillQueue {

    static int[][] matrix = {
            {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    static int targetColor = 0; // Color to be changed
    static int newColor = 2; // Color to be used for filling

    static Queue queue = new Queue(1000); // Queue size

    public static void main(String[] args) {
        start();
    }

    // Method to initiate the flood fill
    static void start() {
        System.out.println("\nFlood Fill \n");
        printMatrix(); // Print the initial matrix

        // Request the starting point for the FloodFill process
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite as coordenadas x e y (separadas por espaço):");
        int startY = scanner.nextInt();
        int startX = scanner.nextInt();

        floodFill(startX, startY); // Start the flood fill process
    }

    // Flood fill algorithm using a queue
    static void floodFill(int x, int y) {
        // Create an array to store the coordinates (x, y) where the FloodFill will begin
        int[] startPoint = {x, y};
        queue.enqueue(startPoint); // Add the initial point to the queue

        // Continue the loop while the queue is not empty
        while (!queue.isEmpty()) {
            // Remove the point from the queue as it will be processed
            int[] point = queue.dequeue();
            x = point[0];
            y = point[1];

            // Check if the point is outside the matrix
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
                continue;
            }

            // Check if the point's color is different from the target color
            if (matrix[x][y] != targetColor) {
                continue;
            }

            matrix[x][y] = newColor; // Change the color in the matrix to the new color

            // Create arrays with the coordinates of the 4 neighboring points and add them to the queue for checking
            int[] left = {x, y - 1};
            int[] right = {x, y + 1};
            int[] up = {x - 1, y};
            int[] down = {x + 1, y};

            queue.enqueue(left);
            queue.enqueue(right);
            queue.enqueue(up);
            queue.enqueue(down);

            // Print the matrix after filling a point
            printMatrix();
        }
    }

    // Method to print the matrix
    static void printMatrix() {
        String color;
        // Loop through the matrix rows
        for (int i = 0; i < matrix.length; i++) {
            // Loop through the matrix columns
            for (int j = 0; j < matrix[i].length; j++) {
                // Set the text color based on the matrix value
                if (matrix[i][j] == 2) {
                    color = "\u001B[31m"; // Red (fill color)
                } else {
                    color = "\u001B[0m"; // Reset (default color)
                }

                System.out.print(color + matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
