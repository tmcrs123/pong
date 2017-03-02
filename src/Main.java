import SimpleGFX.SimpleGFXRepresentable;
import SimpleGFX.SimpleGFXRepresentableFactory;
import gameObjects.Field;
import gameObjects.GameObject;
import gameObjects.GameObjectFactory;
import gameObjects.GameObjectType;

import static java.lang.Thread.*;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class Main {

    public static void main(String[] args)  throws InterruptedException{

        SimpleGFXRepresentableFactory simpleGFXRepresentableFactory = new SimpleGFXRepresentableFactory();

        Pong pong = new Pong();


        pong.init(simpleGFXRepresentableFactory);


        while (true){
            pong.start();
            sleep(10);
        }




    }
}
