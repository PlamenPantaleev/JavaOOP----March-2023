package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_XP = 10;
    private static final int ATTACK_POINTS = 10;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void initializeTestObjects() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.deadDummy = new Dummy(0, DUMMY_XP);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(90, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testWhenDummyIsDead() {
        deadDummy.takeAttack(10);
    }

    @Test
    public void testDeadDummyCannotGiveExp() {
        deadDummy.giveExperience();
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCantGiveExp() {
        dummy.giveExperience();
    }
}
