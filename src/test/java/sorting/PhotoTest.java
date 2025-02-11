package sorting;

import org.javagrader.ConditionalOrderingExtension;
import org.javagrader.Grade;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

@Grade
@ExtendWith(ConditionalOrderingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhotoTest {
    
    @Test
    @Grade(value = 1)
    @Order(0)
    public void testExampleTrue() {
        int [] teamA = new int[]{170, 155, 162, 184};
        int [] teamB = new int[]{160, 172, 190, 185};
        assertEquals(36, Photo.canTakePictures(teamA, teamB));
        assertEquals(36, Photo.canTakePictures(teamB, teamA));
        teamA = new int[]{264, 285, 117, 239};
        teamB = new int[]{286, 121, 240, 292};
        assertEquals(34, Photo.canTakePictures(teamA, teamB));
        assertEquals(34, Photo.canTakePictures(teamB, teamA));
    }
    
    @Test
    @Grade(value = 1)
    @Order(0)
    public void testExampleFalse() {
        int [] teamA = new int[]{144, 173, 158, 195};
        int [] teamB = new int[]{152, 169, 165, 189};
        assertEquals(-1, Photo.canTakePictures(teamA, teamB));
        assertEquals(-1, Photo.canTakePictures(teamB, teamA));
        teamA = new int[]{283, 199, 314, 485};
        teamB = new int[]{523, 296, 314, 264};
        assertEquals(-1, Photo.canTakePictures(teamA, teamB));
        assertEquals(-1, Photo.canTakePictures(teamB, teamA));
    }
    
    
}
