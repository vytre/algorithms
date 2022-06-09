package EksamenPrep.SecondTry.v2022;

import eksamenPrep.secondTry.v2022.Ex02;
import org.junit.jupiter.api.Test;

class Ex02Test {

    @Test
    public void Test1(){
        Ex02.InitiativeHandler initiativeHandler = new Ex02.InitiativeHandler();

        Ex02.Character character1 = new Ex02.Character(Ex02.Initiative.FAST,1,1);
        Ex02.Character character2 = new Ex02.Character(Ex02.Initiative.FAST,2,2);
        Ex02.Character character3 = new Ex02.Character(Ex02.Initiative.FAST,3,3);
        Ex02.Character character4 = new Ex02.Character(Ex02.Initiative.MEDIUM,4,14);
        Ex02.Character character5 = new Ex02.Character(Ex02.Initiative.MEDIUM,5,16);
        Ex02.Character character6 = new Ex02.Character(Ex02.Initiative.SLOW,6,13);


        initiativeHandler.addCharacter(character1);
        initiativeHandler.addCharacter(character2);
        initiativeHandler.addCharacter(character3);
        initiativeHandler.addCharacter(character4);
        initiativeHandler.addCharacter(character5);
        initiativeHandler.addCharacter(character6);

        System.out.println(initiativeHandler.getInitiativeOrder());

    }
}