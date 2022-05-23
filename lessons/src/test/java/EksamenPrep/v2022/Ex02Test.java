package EksamenPrep.v2022;

import eksamenPrep.v2022.Ex02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {


    @Test
    public void vegardTest(){
        Ex02.InitiativeHandler<Integer,String> handler = new Ex02.InitiativeHandler<>();

        Ex02.InitiativeHandler.Character character = new Ex02.InitiativeHandler.Character();

        System.out.println(character.rollInitiative());


    }

}