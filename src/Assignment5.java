import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

public class Assignment5 {
    public static void main(String[] args) throws Exception {
        int[][] mat1 = new int[2][3];
        int[][] mat2 = new int[3][4];
        int[][] mat3 = new int[2][4];
        Random rand = new Random();
        int i, j, k;
        for (i=0; i<mat1.length; i++) {
            for (j=0; j<mat1[i].length; j++) {
                mat1[i][j] = rand.nextInt(10);
            }
        }
        for (i=0; i<mat2.length; i++) {
            for (j=0; j<mat2[i].length; j++) {
                mat2[i][j] = rand.nextInt(10);
            }
        }
        for (i=0; i<mat3.length; i++) {
            for (j=0; j<mat3[i].length; j++) {
                mat3[i][j] = 0;
                for (k=0; k<mat1[i].length; k++) {
                    mat3[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        System.out.println("Matrix 1:");
        for (i=0; i<mat1.length; i++) {
            System.out.println(Arrays.toString(mat1[i]));
        }
        System.out.println("Matrix 2:");
        for (i=0; i<mat2.length; i++) {
            System.out.println(Arrays.toString(mat2[i]));
        }
        System.out.println("Matrix 3:");
        for (i=0; i<mat3.length; i++) {
            System.out.println(Arrays.toString(mat3[i]));
        }
        System.out.println();
        FileWriter writer = new FileWriter("matrix3.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("%d %d\n".formatted(mat3.length, mat3[0].length));
        for (i=0; i<mat3.length; i++) {
            for (j=0; j<mat3[i].length; j++) {
                bw.write("%d".formatted(mat3[i][j]));
                if (j != mat3[i].length - 1)
                    bw.write(" ");
            }
            if (i != mat3.length-1)
            bw.write("\n");
        }
        bw.close();
        FileReader reader = new FileReader("matrix3.txt");
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        String[] size = line.split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        System.out.println("%d %d".formatted(rows, cols));
        int[][] mat4 = new int[rows][cols];
        for (i = 0; i < rows; i++) {
            line = br.readLine();
            String[] row = line.split(" ");
            for (j = 0; j < cols; j++) {
                mat4[i][j] = Integer.parseInt(row[j]);
            }
        }
        System.out.println("Matrix 4:");
        for (i = 0; i < mat4.length; i++) {
            System.out.println(Arrays.toString(mat4[i]));
        }
        br.close();
    }
}
