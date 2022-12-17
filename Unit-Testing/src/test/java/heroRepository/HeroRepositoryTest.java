package heroRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroRepositoryTest {

    private HeroRepository heroRepository;
    private Hero hero;
    private static final String TEST_NAME = "Test_name";
    private static final int TEST_LEVEL = 10;

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
        hero = new Hero(TEST_NAME, TEST_LEVEL);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowWhenHeroIsNull() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowWhenHeroAlreadyExists() {
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void testCreateShouldAddHeroToRepository() {
        int sizeBeforeAdd = heroRepository.getCount();
        heroRepository.create(hero);

        assertEquals(sizeBeforeAdd + 1, heroRepository.getCount());
        assertEquals(TEST_NAME, heroRepository.getHero(TEST_NAME).getName());
    }

    @Test
    public void testRemoveShouldRemoveHeroFromRepository() {
        heroRepository.create(hero);
        int sizeBeforeRemove = heroRepository.getCount();

        assertTrue(heroRepository.remove(hero.getName()));
        assertEquals(sizeBeforeRemove - 1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowWhenNameIsNull() {
        heroRepository.create(hero);
        heroRepository.remove(null);
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        heroRepository.create(hero);
        Hero highestLevelHero = new Hero("another_hero_with_higher_level", 20);
        heroRepository.create(highestLevelHero);

        assertEquals(highestLevelHero, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroes() {
        heroRepository.create(hero);

        assertEquals(1, heroRepository.getHeroes().size());
    }
}