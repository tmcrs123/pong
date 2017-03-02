package SimpleGFX;

import Interfaces.Representable;
import Interfaces.RepresentableFactory;
import gameObjects.GameObjectType;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class SimpleGFXRepresentableFactory implements RepresentableFactory {


    @Override
    public Representable createRepresentation(GameObjectType gameObjectType) {


        Representable representable = null;

        //TODO: Get rid of magic numbers
        switch (gameObjectType) {
            case BALL:
                representable = new SimpleGFXBall(300, 220, 16, 16);
                break;
            case PADDLE:
                representable = new SimpleGFXHumanPaddle(20, 0, 15, 100);
                break;
            case AIPADDLE:
                representable = new SimpleGFXAIPaddle(580, 0, 15, 100);
                break;
            case FIELD:
                representable = new SimpleGFXField(400, 600);
        }

        return representable;

    }
}
