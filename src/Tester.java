import Interfaces.RepresentableFactory;
import KeyboardController.KeyboardController;
import SimpleGFX.SimpleGFXRepresentableFactory;
import gameObjects.*;

import static java.lang.Thread.sleep;

/**
 * Created by tiagoRodrigues on 02/03/2017.
 */
public class Tester {


    public static void main(String[] args) {

        SimpleGFXRepresentableFactory simpleGFXRepresentableFactory = new SimpleGFXRepresentableFactory();


        GameObject field = new GameObjectFactory(simpleGFXRepresentableFactory).createGameObject(GameObjectType.FIELD);

        GameObject humanPaddle = new GameObjectFactory(simpleGFXRepresentableFactory).createGameObject(GameObjectType.HUMANPADDLE);

        KeyboardController cenas = new KeyboardController(((HumanPaddle) humanPaddle), ((Field) field));


        while (true){
            try {

                int speed = 1;
                ((HumanPaddle) humanPaddle).move(0,speed);
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
