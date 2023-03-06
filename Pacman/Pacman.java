import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int COUNT_DOWN_START_VALUE=20;
    private int mouthDelay = COUNT_DOWN_START_VALUE;
    private int index_state;
    private int direction;
    private int prev_direction;
    private static String []d_up;   
    private static String []d_down;  
    private static String []d_right; 
    private static String []d_left;
    private int x_OFFSET;
    private int y_OFFSET;
    private int SPEED;
    
    private int score;
    
    private int image_height;
    private int image_width;
    
   
    public Pacman(){
        d_up    =new String[2];
        d_down  =new String[2];
        d_right =new String[2];
        d_left  =new String[2];
        index_state=0;
        direction=0;
        prev_direction=0;
        SPEED=5;
        x_OFFSET=SPEED;
        y_OFFSET=0;
        d_up[0]    = "images/pacman-close-up.png";
        d_up[1]    = "images/pacman-open-up.png";
        d_down[0]  = "images/pacman-close-down.png";
        d_down[1]  = "images/pacman-open-down.png";
        d_right[0] = "images/pacman-close.png";
        d_right[1] = "images/pacman-open.png";
        d_left[0]  = "images/pacman-close-left.png";
        d_left[1]  = "images/pacman-open-left.png";
        setImage(d_right[0]);
        GreenfootImage image = getImage();
        image_width=image.getWidth()/2;
        image_height=image.getHeight()/2;
        
    }
    
    public void act()
    {
        changeState();
        
        checkCollitions();
        
        move();
        
        displayHUB();
    }
    
    private void checkCollitions(){
        World world = getWorld();
        //collitions whit items
        Item item = (Item)this.getOneIntersectingObject(Item.class);
        if(item != null){
            score+=item.getValue();
            this.getWorld().removeObject(item);
        }
        //collitions whit walls
        Wall wall = (Wall)this.getOneIntersectingObject(Wall.class);
        if(wall != null){
            x_OFFSET=0;
            y_OFFSET=0;
            if(Math.abs(wall.getX()-this.getX()) > Math.abs(wall.getY()-this.getY())){
                if(wall.getX()>this.getX()){
                setLocation(getX()-1,getY());
                }else{
                setLocation(getX()+1,getY());
                }
            }else{
                if(wall.getY()>this.getY()){
                setLocation(getX(),getY()-1);
                }else{
                setLocation(getX(),getY()+1);
                }
            }
        }
        //collitions whit edges
           
    
    }
    
    
    private void displayHUB(){
        World world = getWorld();
        world.showText("Score: "+ score, world.getWidth()-100,20);
    }
    
    
    private void changeState(){
        
        if(Greenfoot.isKeyDown("right"))
        {
            direction=0;
            x_OFFSET=SPEED;
            y_OFFSET=0;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            direction=1; 
            x_OFFSET=-SPEED;
            y_OFFSET=0;
        }
        if(Greenfoot.isKeyDown("up"))
        {
            direction=2;
            x_OFFSET=0;
            y_OFFSET=-SPEED;
        }
        if(Greenfoot.isKeyDown("down"))
        {
            direction=3;
            x_OFFSET=0;
            y_OFFSET=SPEED;
        }
        mouthDelay--;
        if(mouthDelay<0||prev_direction!=direction ){
            if(mouthDelay<0){
                mouthDelay=COUNT_DOWN_START_VALUE;
            }
            if(index_state==0)
            {
                index_state=1;
            }else{
                index_state=0;
            }
            changeImage();
        }
        prev_direction=direction;
    }
    
    private void changeImage(){
        switch(direction){
            case 0: setImage(d_right[index_state]);
                break;
            case 1: setImage(d_left[index_state]);     
                break;
            case 2: setImage(d_up[index_state]);  
                break;
            case 3: setImage(d_down[index_state]);
                break;
        }
    }
    private void move(){
        World world=getWorld();
        int next_x_r=getX()+image_width + x_OFFSET;
        int next_x_l=getX()-image_width + x_OFFSET;
        int next_y_u=getY()-image_height + y_OFFSET;
        int next_y_d=getY()+image_height + y_OFFSET;
       
        if( next_x_r < world.getWidth() &&  next_x_l > 0 &&
            next_y_d < world.getHeight() &&  next_y_u > 0){
                setLocation(getX() + x_OFFSET , getY() + y_OFFSET);
            }
            
    }
    
}
