import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Explorer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explorer extends Actor
{
    /**
     * Act - do whatever the Explorer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
        limitToBorder();
        showIslands();
    }
    
    public void movimentar() {
        // Movimento com as setas do teclado
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 2); // Move para cima
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 2); // Move para baixo
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 2, getY()); // Move para a esquerda
            setImage("mainCharac.png");
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 2, getY()); // Move para a direita
            setImage("mainCharacRight.png");
        }
    }
    
    public void limitToBorder(){
        Actor border = getOneIntersectingObject(Border.class);
        if(border != null){
            if (Greenfoot.isKeyDown("w")) {
                setLocation(getX(), getY() + 2); // Nega o movimento pra cima
            }
            if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() - 2); // Nega o movimento pra baixo
            }
            if (Greenfoot.isKeyDown("a")) {
                setLocation(getX() + 2, getY()); // Nega o movimento pra esquerda
            }
            if (Greenfoot.isKeyDown("d")) {
                setLocation(getX() - 2, getY()); // Nega o movimento pra direita
            }
        }
    }
    
    public void showIslands(){
                   
    }
}
