
package KeyboardController;

import Interfaces.MovableRepresentable;
import Interfaces.VerticalRepresentable;
import SimpleGFX.SimpleGFXHumanPaddle;
import gameObjects.Field;
import gameObjects.HumanPaddle;
import gameObjects.MovableGameObject;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

    /**
     * Created by tiagoRodrigues on 02/02/2017.
     */
    public class KeyboardController implements KeyboardHandler {


        private HumanPaddle controllableHumanPaddle;
        private Field field;
        private Keyboard keyboard;


        public KeyboardController(HumanPaddle humanPaddle, Field field) {

            keyboard = new Keyboard(this);
            this.keyboard();
            this.controllableHumanPaddle = humanPaddle;
            this.field = field;

        }


        public void keyboard() {

            KeyboardEvent up = new KeyboardEvent();
            up.setKey(KeyboardEvent.KEY_UP);
            up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(up);

            KeyboardEvent down = new KeyboardEvent();
            down.setKey(KeyboardEvent.KEY_DOWN);
            down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(down);

            KeyboardEvent releaseUp = new KeyboardEvent();
            releaseUp.setKey(KeyboardEvent.KEY_UP);
            releaseUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboard.addEventListener(releaseUp);

            KeyboardEvent releaseDown = new KeyboardEvent();
            releaseDown.setKey(KeyboardEvent.KEY_DOWN);
            releaseDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboard.addEventListener(releaseDown);


        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            //todo this method shoud only set a bol true or false

            switch (keyboardEvent.getKey()){
                case KeyboardEvent.KEY_UP:


                    //this returns a representable
                    ((VerticalRepresentable)controllableHumanPaddle.getRepresentable()).setMovingUp(true);


                    break;
                case KeyboardEvent.KEY_DOWN:
                    ((VerticalRepresentable)controllableHumanPaddle.getRepresentable()).setMovingDown(true);
                    break;
                default:
                    System.out.println("Shit happened");
                    break;

            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

            SimpleGFXHumanPaddle humanPaddle = (SimpleGFXHumanPaddle) controllableHumanPaddle.getRepresentable();

            switch (keyboardEvent.getKey()){

                case KeyboardEvent.KEY_UP:
                    humanPaddle.setMovingUp(false);
                    controllableHumanPaddle.setPositionY(humanPaddle.getY());
                    break;

                case KeyboardEvent.KEY_DOWN:
                    humanPaddle.setMovingDown(false);
                    controllableHumanPaddle.setPositionY(humanPaddle.getY());
                    break;

                default:
                    System.out.println("shit");
            }

        }

    }
