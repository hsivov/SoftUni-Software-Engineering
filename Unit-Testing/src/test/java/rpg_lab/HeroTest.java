package rpg_lab;

import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    private static final String HERO_NAME = "Hristo";
    private static final int TARGET_XP = 10;

    @Test
    public void testHeroGainExperienceWhenAttackDeadTarget() {

        Weapon fakeWeapon = mock(Weapon.class);
        Target fakeTarget = mock(Target.class);

        when(fakeTarget.isDead()).thenReturn(true);
        when(fakeTarget.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);

        assertEquals(TARGET_XP, hero.getExperience());
    }

}
