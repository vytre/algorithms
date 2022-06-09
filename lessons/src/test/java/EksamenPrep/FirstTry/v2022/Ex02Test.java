package EksamenPrep.FirstTry.v2022;

import eksamenPrep.firsTry.v2022.Ex02;
import org.junit.jupiter.api.Test;

class Ex02Test {


    @Test
    public void vegardTest(){
        Ex02.InitiativeHandler<Integer,String> handler = new Ex02.InitiativeHandler<>();

        Ex02.InitiativeHandler.Character character = new Ex02.InitiativeHandler.Character();

        System.out.println(character.rollInitiative());


    }

}