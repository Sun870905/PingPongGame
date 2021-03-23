package pong;

/**
 * This is the model of the simple Pong game.
 * It holds the properties of the ball, paddle, and PongPanel.
 * It also determines the movement of the ball.
 * 
 */
public class PongModel {
    // properties of the ball
    private double ballX, ballY;
    private double velocityX, velocityY;
    private double change;
    private int ballDiameter;

    // properties of the paddle
    private double paddleX, paddleY;
    private int paddleWidth, paddleHeight;

    // properties of the panel
    private int width, height;

    // properties of the game
    private int hits, misses;
    private boolean pause;

    public PongModel() {
        paddleX = 0;
        paddleY = 10;
        paddleWidth = 100;
        paddleHeight = 10;
        ballX = 10000;
        ballY = 10000;
        ballDiameter = 10;
        change = 3;
        velocityX = change;
        velocityY = change;
        width = 0;
        height = 0;
        hits = 0;
        misses = 0;
        pause = false;
    }

    /**
     * Set the position of the paddle based on the
     * position of the mouse
     * @param x horizontal position of the mouse
     * @param y vertical position of the mouse
     */
    public void setPaddle(int x, int y) {
        paddleX = x - paddleWidth / 2;
        if (paddleX > width - paddleWidth) {
            paddleX = width - paddleWidth;
        }
        if (paddleX < 0) {
            paddleX = 0;
        }
    }

    /**
     * Move the ball to its next position based on its
     * current position, its velocity, and the position
     * of the walls and the paddle.
     */
    public void moveBall() {
        // Don't do anything if the game is paused.
        // Also, this might get called before the window is opened.
        if (height == 0 || pause) {
            return;
        }
        ballX += velocityX;
        ballY += velocityY;

        // imperfect collision detection with the paddle
        if (ballX + ballDiameter / 2 > paddleX && 
                ballX + ballDiameter / 2 < paddleX + paddleWidth &&
                ballY > paddleY && ballY < paddleY + paddleHeight) {
            velocityY = change;
            hits++;
        }

        // detect movement into walls and bounce appropriately
        // bounce into right wall
        if (ballX > width - ballDiameter) {
            ballX = width - ballDiameter;
            velocityX = -change;
        }
        // bounce into left wall
        if (ballX < 0) {
            ballX = 0;
            velocityX = change;
        }
        // bounce into bottom wall (wall far from paddle)
        if (ballY > height - ballDiameter && velocityY >= 0) {
            ballY = height - ballDiameter;
            velocityY = -change;
        }
        // bounce into top wall (wall near paddle)
        if (ballY < -ballDiameter) {
            ballY = height;
            velocityY = -change;
            misses++;
        }

    }

    // Lots of getters and a couple setters.

    public double getBallX() { return ballX; }

    public double getBallY() { return ballY; }

    public int getBallDiameter() {	return ballDiameter; }

    public double getPaddleX() { return paddleX; }

    public double getPaddleY() { return paddleY; }

    public int getPaddleWidth() { return paddleWidth; }

    public int getPaddleHeight() { return paddleHeight; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }
    
    public int getHits() { return hits; }

    public int getMisses() { return misses; }

    public boolean getPause() { return pause; }

    public void setSize(int width, int length) {
        this.width = width;
        this.height = length;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
