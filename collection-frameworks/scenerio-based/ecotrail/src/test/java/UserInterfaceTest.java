import ecotrail.Trail;
import ecotrail.TrailUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserInterfaceTest {
    private TrailUtil service;

    @BeforeEach
    void  setUp(){
        service =new TrailUtil();
        // Add sample data (same as your sample input)
        service.addTrailRecord(new Trail("T104", "MonumentValley", "RockyMountains", "Easy", 120));
        service.addTrailRecord(new Trail("T103", "KumaraParvatha", "Sahyadri", "Hard", 250));
        service.addTrailRecord(new Trail("T102", "ValleyOfFlowers", "Himalayas", "Moderate", 180));
        service.addTrailRecord(new Trail("T101", "EverestBaseCamp", "Himalayas", "Hard", 250));
    }

    @Test
    void testGetTrailById_found() {
        Trail t = service.getTrailById("T103");

        assertNotNull(t);
        assertEquals("T103", t.getTrailId());
        assertEquals(250, t.getHikeCount());
    }

    @Test
    void testGetTrailById_notFound() {
        Trail t = service.getTrailById("T999");
        assertNull(t);
    }


    @Test
    void testGetMostHikedTrails() {
        Set<Trail> result = service.getMostHikedTrails();

        assertEquals(2, result.size()); // T101 and T103 both have 250

        Set<String> ids = new HashSet<>();
        for (Trail t : result) {
            ids.add(t.getTrailId());
        }
        System.out.println(ids);
        assertTrue(ids.contains("T101"));
        assertTrue(ids.contains("T103"));
    }

}
