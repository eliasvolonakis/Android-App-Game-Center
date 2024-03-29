package a207phase1.fall2018.gamecentre;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Stack-Like Container for saved GameStates
 *
 */
public class GameStatesContainer implements Serializable {
    /**
     * ArrayList created which will store GameStates
     */
    public ArrayList<savesTuple> contents = new ArrayList<>();

    /**
     * Max number of undos.
     */
    private int numUndos;

    /**
     * Returns number of undos.
     */
    public int getNumUndos() {
        return numUndos;
    }

    /**
     * Current move counter.
     */
    public int currentMoveCounter = contents.size();

    /**
     * Counter at (current - numUndos). Can never decrease and the maximum
     * difference between it and currentMoveCounter is numUndos.
     */
    public int undoMoveCounter = 0;

    /**
     * Constructor for GameStatesContainer which initializes the number of
     * undos and adds the initialGameState to the GameStatesContainer.
     */
    public GameStatesContainer( int numUndos) {
        this.numUndos = numUndos;
    }

    /**
     * Returns the most recent autosave available from the container
     */
    public savesTuple getPreviousSave(){
        return this.contents.get(currentMoveCounter - 1);
    }


}

