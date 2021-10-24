// MEDIUM - https://leetcode.com/problems/robot-bounded-in-circle/

public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // initial position at origin
        int Xpos = 0;
        int Ypos = 0;
        // facing north
        int idx = 0;

        for (int i=0; i<instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                idx = (idx + 3) % 4;
            } else if (instructions.charAt(i) == 'R') {
                idx = (idx + 1) % 4;
            } else {
                Xpos += dirs[idx][0];
                Ypos += dirs[idx][1];
            }
        }

        return (Xpos == 0 && Ypos == 0) || (idx != 0);
    }

}
