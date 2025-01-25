import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FurnaceHUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FurnaceHUD extends Actor
{
    private boolean hudVisible;
    private int selected = 1;
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        handleHUDToggle();
        if (hudVisible) {
            smeltingItem();
            updateHUD();
            moveSlots();
        }
    }

    public FurnaceHUD() {
        setImageInitial();
        hudVisible = true;
    }

    public void setImageInitial() {
        // Cria o HUD
        GreenfootImage imagem = new GreenfootImage("furnace-HUD.png");
        // Aplicamos transparencia no HUD
        imagem.setTransparency(240);
        // Aplica a imagem
        setImage(imagem);
        // Atualiza a HUD
        updateHUD();
    }

    public void updateHUD() {
        // Cria a imagem base do HUD
        GreenfootImage imagem = new GreenfootImage("furnace-HUD.png");

        // Adiciona a imagem do slot selecionado
        ///String selectedImageName = "Fselected-" + selected + ".png";
        ///GreenfootImage selectedImage = new GreenfootImage(selectedImageName);
        ///imagem.drawImage(selectedImage, 0, 0); // Posiciona a imagem do slot selecionado no HUD
        
        // Adiciona o texto do número de Log
        GreenfootImage textoLog = new GreenfootImage("Troncos Disponiveis " + Inventory.getLog(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoLog, 200, 200); // Posiciona o texto no HUD
        
        // Adiciona o texto do número de Copper Ore
        GreenfootImage textoCopperOre = new GreenfootImage("MCobres: " + Inventory.getCopperOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoCopperOre, 80, 365); // Posiciona o texto no HUD
        
        // Adiciona o texto do número de Tin Ore
        GreenfootImage textoTinOre = new GreenfootImage("MEstanhos: " + Inventory.getTinOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoTinOre, 140, 365); // Posiciona o texto no HUD
    
        // Adiciona o texto do número de Bronze
        GreenfootImage textoBronze = new GreenfootImage("Bronzes: " + Inventory.getBronze(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoBronze, 200, 365); // Posiciona o texto no HUD

        // Adiciona o texto do número de IronOre
        GreenfootImage textoIronOre = new GreenfootImage("MFerros: " + Inventory.getIronOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoIronOre, 260, 365); // Posiciona o texto no HUD

        // Adiciona o texto do número de Gold Ore
        GreenfootImage textoGoldOre = new GreenfootImage("MOuro: " + Inventory.getGoldOre(), 15, Color.WHITE, new Color(0, 0, 0, 0));
        imagem.drawImage(textoGoldOre, 320, 365); // Posiciona o texto no HUD

        // Define a nova imagem com tudo desenhado
        setImage(imagem);
    }


        public void handleHUDToggle() {
        if (Furnace.getOpenFurnace()) {
            if (!hudVisible) {
                hudVisible = true;
                setImageInitial(); // Atualiza e exibe o HUD
            }
        } 
        else {
            if (hudVisible) {
                hudVisible = false;
                setImage((GreenfootImage) null); // Esconde o HUD
            }
        }
    }
    
    public void moveSlots(){
        if(Greenfoot.isKeyDown("right") && hudVisible){
            if (selected < 12){ 
                selected++;
                Greenfoot.delay(10);
                }
        }
    
        if(Greenfoot.isKeyDown("left") && hudVisible){
             if (selected > 1){ 
                selected--;
                Greenfoot.delay(10);
                }
        }
    
        if(Greenfoot.isKeyDown("down") && hudVisible && selected + 6  < 13){
         selected += 6;
         Greenfoot.delay(10);
        }
    
        if(Greenfoot.isKeyDown("up") && hudVisible && selected - 6 > 0){
         selected -= 6;
         Greenfoot.delay(10);
        }
    }
    
    public void smeltingItem(){
    
    }
}