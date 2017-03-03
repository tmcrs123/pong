package gameObjects;

import Interfaces.MovableRepresentable;
import Interfaces.RepresentableFactory;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public class GameObjectFactory {


    private RepresentableFactory factory;

    public GameObjectFactory(RepresentableFactory factory) {
        this.factory = factory;
    }


    public GameObject createGameObject(GameObjectType gameObjectType) {

        GameObject gameObject = null;

        switch (gameObjectType) {
            case BALL:
                gameObject = new Ball((MovableRepresentable) factory.createRepresentation(gameObjectType));
                break;
            case HUMANPADDLE:
                gameObject = new HumanPaddle((MovableRepresentable) factory.createRepresentation(gameObjectType));
                break;
            case AIPADDLE:
                gameObject = new AIPaddle((MovableRepresentable) factory.createRepresentation(gameObjectType));
                break;
            case FIELD:
                gameObject = new Field(factory.createRepresentation(gameObjectType));
                break;
        }


        return gameObject;

    }


}





