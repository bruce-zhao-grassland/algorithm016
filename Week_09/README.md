不同路径2，带障碍

状态转移方程

if (obstacleGrid(i,j) == 0) {

​	f(i,j) = f(i-1,j) + f(i, j-1);

} else {

​	f(i,j) = 0;

}