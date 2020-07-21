package week1_basic_data_structures;

import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeHeight {
        int n;
        int parent[];

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            // Replace this code with a faster implementation
            // -1 0 4 0 3
            //  3 0 0 2 1
            //  4 -1 4 1 1
            int maxHeight = 0;
            int[] depths = new int[n];
            int height = 0;
            int rootIndex = 0;
            for (int vertex = 0; vertex < n; vertex++) {
                if(depths[vertex] == 0 && parent[vertex] != -1) {
                    height = -1;
                    for (int i = vertex; i != -1; i = parent[i]) {
                        if (height + 1 < depths[i]) {
                            break;
                        }
                        depths[i] = height + 1;
                        height++;
                    }
                }
            }
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == -1) {
                    rootIndex = i;
                    break;
                }
            }
            return depths[rootIndex] + 1;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
