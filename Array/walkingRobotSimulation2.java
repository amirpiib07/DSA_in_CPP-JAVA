class Robot {
    int w, h;
    int x = 0, y = 0;
    int dir = 0; // 0=East, 1=North, 2=West, 3=South
    int perimeter;

    String[] directions = {"East", "North", "West", "South"};
    int[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.perimeter = 2 * (w + h) - 4;
    }

    public void step(int num) {
        if (perimeter == 0) return;

        num %= perimeter;

        // 🔴 IMPORTANT EDGE CASE
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3; // South
            }
            return;
        }

        while (num > 0) {
            int nx = x + moves[dir][0];
            int ny = y + moves[dir][1];

            // boundary check
            if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                dir = (dir + 1) % 4; // turn CCW
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return directions[dir];
    }
}