package SimpleGFX;

import Interfaces.MovableRepresentable;
import Interfaces.Representable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by tiagoRodrigues on 02/02/2017.
 */
public abstract class SimpleGFXMovableRepresentable extends SimpleGFXRepresentable implements MovableRepresentable{



    public SimpleGFXMovableRepresentable(Shape shape) {
        super(shape);
    }

    @Override
    public Shape getShape() {
        return super.getShape();
    }

}

