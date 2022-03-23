package org.pg4200.ex03;

import java.util.Comparator;

public class GameUserComparator implements Comparator<GameUser> {

    @Override
    public int compare(GameUser a, GameUser b) { // Tar imot 2 GameUser objects
        int pointDiff = a.getPoints() - b.getPoints(); // Poeng forskjell

        if(pointDiff == 0){ // Hvis like mange poeng
            System.out.println(a.getUserId().compareTo(b.getUserId()));
            return a.getUserId().compareTo(b.getUserId());
        }

        return pointDiff;
    }
}
