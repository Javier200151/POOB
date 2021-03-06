package Shapes;


/**
 * Write a description of class Figura here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Figura
{
    protected int xPosition;
    protected int yPosition;
    protected String color;
    protected boolean isVisible;

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public Figura(int xp,int yp,String color)
    {
        xPosition = xp;
        yPosition = yp;
        this.color = color;
        isVisible = false;
    }
    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public  void makeVisible(){
        isVisible = true;
        draw();
    }
    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void  makeInvisible(){
        erase();
        isVisible = false;
    }
    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the circle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        }else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }
    public abstract void draw();
    
    /**
     * Erase the circle on screen.
     */
    public void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    /*
     * Erase the triangle on screen.
     */
    public void blick(int times) 
    {
        Canvas canvas = Canvas.getCanvas();
        for(int j = 0; j < times*2; j++)
        {
            if (isVisible)
            {
                makeInvisible();
            }else
            {
                makeVisible();
            }
            canvas.wait(100);
        }
    }
    public void setPosition(int newXposition,int newYposition)
    {
        xPosition=newXposition;
        yPosition=newYposition;
    }
}
