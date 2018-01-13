package xyz.amrro.jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class JokeRepository {

    private final List<String> jokes;

    public JokeRepository() {
        this.jokes = new ArrayList<>();
        jokes.add("A programmer: a machine that turns coffee into code.");
        jokes.add("Real programmer count from 0.");
        jokes.add("Chuck Norris writes code that optimize itself.");
        jokes.add("The truth is out there. Anybody got the URL?");
        jokes.add("The Internet: where men are men, women are men, and children are FBI agents.");
        jokes.add("If at first you don’t succeed; call it version 1.0.");
        jokes.add("Beware of programmers that carry screwdrivers.");
        jokes.add("Hey! It compiles! Ship it!");
        jokes.add("The more I C, the less I see.");
        jokes.add("My attitude isn’t bad. It’s in beta.");
    }

    public String getJoke() {
        final int rand = new Random().nextInt(jokes.size());
        return jokes.get(rand);
    }

    public static String generateJoke() {
        return new JokeRepository().getJoke();
    }
}
