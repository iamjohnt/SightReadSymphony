package game;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.Queue;

public class MusicObjectAnimator {

    private boolean isAnimating = false;

    public void moveAllMusicObjectsLeft(Queue<MusicObject> musicObjects, double xDistance) {
        System.out.println(isAnimating);
        if (isAnimating == false) {
            isAnimating = true;
            LinkedList<MusicObject> linkedList = (LinkedList) musicObjects;
            int lastOne = linkedList.size() - 1;
            for (int i = 0; i < linkedList.size(); i++) {
                boolean isLastOne = i == lastOne;
                moveMusicObject(linkedList.get(i), xDistance, isLastOne);
            }
        }
    }

    private void moveMusicObject(MusicObject musicObject, double xDistance, boolean isLastMusicObject) {
        Node[] notes = musicObject.getNotesViews();
        Node[] accidentals = musicObject.getAccidentalViews();
        Node[] ledgers = musicObject.getLedgerRectangles();
        Node[] noteInfos = musicObject.getDescriptionLabels();

        for (int i = 0; i < notes.length; i++) {
            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(50));
            trans.setByX(xDistance);
            trans.setCycleCount(1);
            trans.setAutoReverse(false);
            trans.setNode(notes[i]);
            trans.play();
        }
        for (int i = 0; i < accidentals.length; i++) {
            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(50));
            trans.setByX(xDistance);
            trans.setCycleCount(1);
            trans.setAutoReverse(false);
            trans.setNode(accidentals[i]);
            trans.play();
        }
        for (int i = 0; i < noteInfos.length; i++) {
            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(50));
            trans.setByX(xDistance);
            trans.setCycleCount(1);
            trans.setAutoReverse(false);
            trans.setNode(noteInfos[i]);
            trans.play();
        }
        for (int i = 0; i < ledgers.length; i++) {
            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(50));
            trans.setByX(xDistance);
            trans.setCycleCount(4);
            trans.setAutoReverse(false);
            trans.setNode(ledgers[i]);
            if (isLastMusicObject) {
                trans.setOnFinished(event -> isAnimating = false);
                System.out.println("set is false HERE");
            }
            trans.play();
        }
    }

    public boolean isAnimating() {
        return isAnimating;
    }
}
