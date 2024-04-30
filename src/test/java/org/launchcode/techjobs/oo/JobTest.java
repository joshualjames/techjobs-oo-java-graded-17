package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job coyote = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(coyote instanceof Job);
        assertEquals("Product tester", coyote.getName());

        assertTrue(coyote.getEmployer() instanceof Employer);
        assertEquals(coyote.getEmployer().toString(), "ACME");

        assertTrue(coyote.getLocation() instanceof Location);
        assertEquals(coyote.getLocation().toString(), "Desert");

        assertTrue(coyote.getPositionType() instanceof PositionType);
        assertEquals(coyote.getPositionType().toString(), "Quality control");

        assertTrue(coyote.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(coyote.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job jobTest1 = new Job("Couch potato", new Employer("Lays"), new Location("Saint Louis"),
                new PositionType("Quality assurance"), new CoreCompetency("Consumption"));
        Job jobTest2 = new Job("Couch potato", new Employer("Lays"), new Location("Saint Louis"),
                new PositionType("Quality assurance"), new CoreCompetency("Consumption"));

        assertFalse(jobTest1.equals(jobTest2));
    }

}
