package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 8; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        int i=0;
        int j=-10;
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {                
                    super.setImage(sprite.get(i));
                    super.setX(j);
                    Thread.sleep(80);
                        if(i==7){

                            i=0;
                        }if (j>=820){
                            j=-10;
                        }
                    i++;
                    j+=10;
                                   
            } 
            catch (InterruptedException ex) {}
        }
    }
}
