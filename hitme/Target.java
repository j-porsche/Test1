package hitme;

import java.awt.*;
import java.util.*;

public class Target {

    public static final int[] sizes = {7, 6, 5, 4, 3, 2, 1};
    public static final Color[] colours = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA};
    public static final int[] scores = {1, 5, 10, 15, 20, 25, 30};

    Point position;
    int size;
    Color colour;
    int score;
    final long lifespan = 5000L;
    long birthDate;
    long age;

    public void initialise(Rectangle box) {

        // Get random value between 1 and 7.
        Random randomiser = new Random();
        int r = randomiser.nextInt(Target.sizes.length);

        // Limit size of target to 20 % of minimal dimension.
        this.size = Target.sizes[r] * Math.min(box.width, box.height) / (Target.sizes.length * 5);

        int x = (int) (Math.random() * (box.width - 2 * this.size));
        int y = (int) (Math.random() * (box.height - 2 * this.size));

        // CAUTION! The position is the CENTRE of the circle.
        this.position = new Point(x + this.size, y + this.size);
        this.colour = Target.colours[r];
        this.score = Target.scores[r];
        this.birthDate = System.currentTimeMillis();
        this.age = 0L;
    }

    public Color fadeColour(long age) {

        int r = this.colour.getRed();
        int g = this.colour.getGreen();
        int b = this.colour.getBlue();
        // Fade using alpha channel.
        int alpha = (int) (age * 255 / this.lifespan);

        // Verify permitted range.
        if (alpha > 255) {

            alpha = 255;

        } else if (alpha < 0) {

            alpha = 0;
        }

        Color c = new Color(r, g, b, 255 - alpha);

        return c;
    }

    public void ageTarget(final long absTime) {

        this.age = absTime - this.birthDate;
    }

    public boolean containsPoint(Point p) {

        boolean b = false;
        boolean xp = (p.x >= (this.position.x - (this.size / 2)));
        boolean xs = (p.x < (this.position.x + (this.size / 2)));
        boolean yp = (p.y >= (this.position.y - (this.size / 2)));
        boolean ys = (p.y < (this.position.y + (this.size / 2)));

        if (xp && xs && yp && ys) {

            b = true;
        }

        return b;
    }
}
