/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.generator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marce
 */
public class BattleGeneratorTest {
    BattleGenerator instance;
    
    
    public BattleGeneratorTest() {
        
    }
    
    @Before
    public void setUp() {
        instance = new BattleGenerator();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BattleGenerator.
     */
    @Test
    public void testMain() throws Exception {
    }

    /**
     * Test of menu method, of class BattleGenerator.
     */
    @Test
    public void testMenu() {
    }

    /**
     * Test of realmMenu method, of class BattleGenerator.
     */
    @Test
    public void testRealmMenu() {
    }

    /**
     * Test of pointsMenu method, of class BattleGenerator.
     */
    @Test
    public void testPointsMenu() {
    }

    /**
     * Test of rollD4 method, of class BattleGenerator.
     */
    @Test
    public void testRollD4() {
        int result = BattleGenerator.rollD4();
        int range = 50;
        for (int i = 0; i < range; i++){
            result = BattleGenerator.rollD4();
            assertTrue(-1 < result);
            assertTrue(result <= 3);
        }
    }

    /**
     * Test of rollD6 method, of class BattleGenerator.
     */
    @Test
    public void testRollD6() {
        int result = BattleGenerator.rollD6();
        int range = 50;
        for (int i = 0; i < range; i++){
            result = BattleGenerator.rollD6();
            assertTrue(-1 < result);
            assertTrue(result <= 5);
        }
        
    }

    /**
     * Test of characterSheet method, of class BattleGenerator.
     */
    @Test
    public void testCharacterSheet() throws Exception {
    }
    
}
