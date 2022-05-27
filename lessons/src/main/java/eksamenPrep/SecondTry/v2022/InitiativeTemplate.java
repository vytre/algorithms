package eksamenPrep.SecondTry.v2022;

import java.util.ArrayList;

public interface InitiativeTemplate {
    public abstract void addCharacter(Ex02.Character character);
    public abstract boolean removeCharacter(int characterInitiative);
    public abstract ArrayList<Ex02.Character> getInitiativeOrder();
}
