package game;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Queue;

public class MusicObjectAnimator {

    private boolean isAnimating = false;

    public void moveAllMusicObjectsLeft(Queue<MusicObject> musicObjects, double xDistance) {
        isAnimating = true;
        while (!musicObjects.isEmpty()) {
            MusicObject curr = musicObjects.remove();
            if (musicObjects.isEmpty()) {
                moveMusicObject(curr, xDistance, true);
            } else {
                moveMusicObject(curr, xDistance, false);
            }
        }
    }

    private void moveMusicObject(MusicObject musicObject, double xDistance, boolean isLastMusicObject) {
        ImageView[] notes = musicObject.getNotesViews();
        ImageView[] accidentals = musicObject.getNotesViews();
        Rectangle[] ledgers = musicObject.getLedgerRectangles();

        isAnimating = true;
        for (int i = 0; i < notes.length; i++) {
            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(50));
            trans.setByX(xDistance);
            trans.setCycleCount(4);
            trans.setAutoReverse(true);
            trans.setNode(notes[i]);
            trans.play();
        }
        for (int i = 0; i < accidentals.length; i++) {
            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(50));
            trans.setByX(xDistance);
            trans.setCycleCount(4);
            trans.setAutoReverse(true);
            trans.setNode(accidentals[i]);
            trans.play();
        }
        for (int i = 0; i < ledgers.length; i++) {
            TranslateTransition trans = new TranslateTransition();
            trans.setDuration(Duration.millis(50));
            trans.setByX(xDistance);
            trans.setCycleCount(4);
            trans.setAutoReverse(true);
            trans.setNode(ledgers[i]);
            if (isLastMusicObject) {
                trans.setOnFinished(event -> isAnimating = false);
            }
            trans.play();
        }
    }

    public boolean isAnimating() {
        return isAnimating;
    }
}
