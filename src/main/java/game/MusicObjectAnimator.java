package game;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.Queue;

/** Overview - handles animating music objects (notes, intervals, chords)
 * UseCase - will be instantiated within Spawner, which will call MusicObjectAnimator's methods upon spawning or despawning
 * FYI - animation shouldn't be done while something is animating, so we use a boolean called isAnimating */
public class MusicObjectAnimator {

    private boolean isAnimating = false;

    /** goes through queue of music objects, and moves all it's internal node objects left a certain amount */
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

    /* gets all the individual notes of the music object, and animates it a certain X distance */
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
            trans.setCycleCount(1);
            trans.setAutoReverse(false);
            trans.setNode(ledgers[i]);
            if (isLastMusicObject) {
                // this is the last thing to animate, so one done, we set isAnimating to false
                trans.setOnFinished(event -> isAnimating = false);
            }
            trans.play();
        }
    }

    public boolean isAnimating() {
        return isAnimating;
    }
}
