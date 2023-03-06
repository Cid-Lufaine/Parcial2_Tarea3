import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Wall(),230,80);
        addObject(new Wall(),230,108);
        addObject(new Wall(),230,136);
        addObject(new Apple(),476,66);
        addObject(new Big_Item(),84,145);
        addObject(new Cherry(),477,274);
        addObject(new Lemon(),149,53);
        addObject(new Small_Item(),193,194);   
        addObject(new Strawberry(),357,318);
        addObject(new Pacman(),100,300);
    }
}
