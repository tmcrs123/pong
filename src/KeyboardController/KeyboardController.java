
package KeyboardController;

import gameObjects.Field;
import gameObjects.Paddle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

    /**
     * Created by tiagoRodrigues on 02/02/2017.
     */
    public class KeyboardController implements KeyboardHandler {


        private Paddle controlablePaddle;
        private Field field;
        private Keyboard keyboard;


        public KeyboardController(Paddle paddle , Field field) {

            keyboard = new Keyboard(this);
            this.keyboard();
            this.controlablePaddle = paddle;
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
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            //todo this method shoud only set a bol true or false

            switch (keyboardEvent.getKey()){
                case KeyboardEvent.KEY_UP:
                    if (controlablePaddle.getRepresentable().getY() >0) {
                        System.out.println(controlablePaddle.getPositionY());
                        controlablePaddle.move(0, -controlablePaddle.getPaddleSpeed());
                        controlablePaddle.setPositionY(controlablePaddle.getPositionY() - controlablePaddle.getPaddleSpeed());
                        controlablePaddle.getRepresentable().setPosY(controlablePaddle.getPositionY());
                        //System.out.println("pressed up");
                    }
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (controlablePaddle.getRepresentable().getY()+controlablePaddle.getRepresentable().getHeigth()<= field.getRepresentable().getHeigth()) {
                    controlablePaddle.move(0, controlablePaddle.getPaddleSpeed());
                    controlablePaddle.setPositionY(controlablePaddle.getPositionY() + controlablePaddle.getPaddleSpeed());
                    controlablePaddle.getRepresentable().setPosY(controlablePaddle.getPositionY());
                    //System.out.println("pressed down");
                    }
                    break;
                default:
                    System.out.println("Shit happened");
                    break;

            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
