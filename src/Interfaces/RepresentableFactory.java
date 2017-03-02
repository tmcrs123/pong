package Interfaces;

import gameObjects.GameObject;
import gameObjects.GameObjectType;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public interface RepresentableFactory {

    Representable createRepresentation(GameObjectType gameObjectType);
}
