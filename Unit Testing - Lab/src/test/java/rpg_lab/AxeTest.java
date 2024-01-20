package rpg_lab;

import org.junit.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void initializeTestVariables() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.brokenAxe = new Axe(AXE_ATTACK, 0);
    }

    @Test
    public void testIfTheWeaponLosesDurabilityAfterEachAttack() {
        axe.attack(dummy);
        Assert.assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithABrokenWeapon() {

        brokenAxe.attack(dummy);

    }
}
