package eksamenPrep.v2022;

import java.util.ArrayList;

public interface InitiativeTemplate {
    public abstract void addCharacter(Ex02.InitiativeHandler.Character character);

    public abstract boolean removeCharacter(int characterInitiative);

    public abstract ArrayList<Ex02.InitiativeHandler.Character> getInitiativeOrder();
}
