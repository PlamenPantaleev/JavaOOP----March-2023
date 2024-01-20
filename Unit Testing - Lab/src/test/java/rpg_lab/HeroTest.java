package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Asen";
    @Test
    public void testAttackGetsExperienceWhenTargetDies() {
        Weapon weapon = Mockito.mock(Weapon.class);
        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_XP);


        Hero hero = new Hero(HERO_NAME, weapon);
        hero.attack(target);
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }
}
