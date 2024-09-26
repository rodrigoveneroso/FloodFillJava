import java.util.Scanner;

class Stack {
    private int top;
    private final int size;
    private final int[][] stack;

    // Constructor to initialize the stack with a specified size
    public Stack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be greater than 0.");
        }
        this.top = -1; // Indicates that the stack is initially empty
        this.size = size;
        this.stack = new int[size][2]; // Each stack position holds a pair of coordinates (x, y)
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return this.top == -1;
    }

    // Method to push a new point (x, y) onto the stack
    public void push(int[] point) {
        if (top < size - 1) {
            top++; // Increment the top pointer
            stack[top] = point; // Add the point at the top of the stack
        } else {
            System.out.println("Pilha cheia! Não é possível adicionar mais elementos."); // Stack overflow warning
        }
    }

    // Method to pop the top point from the stack
    public int[] pop() {
        if (!isEmpty()) {
            return stack[top--]; // Return the top element and decrement the top pointer
        }
        return null; // If the stack is empty, return null
    }
}

public class FloodFillStack {
    static final int OLD_COLOR = 0; // Color to be replaced
    static final int NEW_COLOR = 2; // New color to fill the matrix
    static final int[][] matrix = {
            {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    static final Stack stack = new Stack(1000); // Stack size set to 1000

    public static void main(String[] args) {
        start(); // Start the flood fill process
    }

    // Method to initiate the flood fill process
    static void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nFlood Fill \n");
            printMatrix(); // Print the initial state of the matrix

            // Ask user for the starting point of the flood fill
            System.out.println("Digite as coordenadas x e y (separadas por espaço):");
            int initialY = scanner.nextInt();
            int initialX = scanner.nextInt();

            floodFill(initialX, initialY); // Perform the flood fill from the given coordinates
        } catch (Exception e) {
            System.out.println("Erro: Por favor, insira números inteiros válidos."); // Error message for invalid input
        }
    }

    // Flood fill algorithm using a stack
    static void floodFill(int x, int y) {
        stack.push(new int[]{x, y}); // Push the initial point onto the stack
        while (!stack.isEmpty()) { // Continue until the stack is empty
            int[] point = stack.pop(); // Pop the top point from the stack
            x = point[0];
            y = point[1];

            // Check if the point is outside the matrix boundaries
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != OLD_COLOR) {
                continue; // If the point is out of bounds or not the target color, skip
            }

            matrix[x][y] = NEW_COLOR; // Update the point with the new color

            // Push the neighboring points (left, right, up, down) onto the stack
            stack.push(new int[]{x, y - 1});
            stack.push(new int[]{x, y + 1});
            stack.push(new int[]{x - 1, y});
            stack.push(new int[]{x + 1, y});

            printMatrix(); // Print the matrix after each step
        }
    }

    // Method to print the matrix
    static void printMatrix() {
        for (int[] row : matrix) {
            for (int value : row) {
                // Use red color for the new color, default for others
                String color = value == NEW_COLOR ? "\u001B[31m" : "\u001B[0m";
                System.out.print(color + value + " "); // Print the matrix value
            }
            System.out.println(); // New line after each row
        }
        System.out.println(); // Additional space after printing the matrix
    }
}
