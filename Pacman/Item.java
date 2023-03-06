import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Item extends Actor
{
    protected int points;
    
    public void act()
    {
        // Add your action code here.
    }
    public int getValue(){
        return points;
    }
}
