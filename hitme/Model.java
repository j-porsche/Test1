package hitme;

import java.util.*;

public class Model extends Observable {

    ArrayList<Target> targets;
    // The frequency for new target to appear (in milliseconds).
    int frequency;
    long time;
    int score;

    public void initialise() {

        this.targets = new ArrayList<Target>();
        this.frequency = 100;
        // Count absolute time since model creation.
        this.time = System.currentTimeMillis();
        this.score = 0;
    }

    // CAUTION! This method IS necessary,
    // since "setChanged" is protected
    // and can only be called here
    // and NOT from the controller.
    public void markChanged() {

        setChanged();
    }
}
