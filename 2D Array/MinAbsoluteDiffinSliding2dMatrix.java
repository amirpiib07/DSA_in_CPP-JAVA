int m = grid.length;
        int n = grid[0].length;

        int rows = m - k + 1;
        int cols = n - k + 1;

        int[][] ans = new int[rows][cols];
        int[] vals = new int[k * k];           // reuse buffer every window

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // fill buffer
                int idx = 0;
                for (int r = i; r < i + k; r++)
                    for (int c = j; c < j + k; c++)
                        vals[idx++] = grid[r][c];

                Arrays.sort(vals);

                int minDiff = Integer.MAX_VALUE;

                for (int x = 1; x < vals.length; x++) {
                    if (vals[x] != vals[x - 1]) {
                        int diff = vals[x] - vals[x - 1];
                        if (diff < minDiff) {
                            minDiff = diff;
                            if (minDiff == 1) break;   // can't go lower for integers
                        }
                    }
                }

                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }

        return ans;
