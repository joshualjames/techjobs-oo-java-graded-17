package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.lineSeparator;
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


    Job testJob = new Job("Astronaut", new Employer("NASA"), new Location("Space"), new PositionType("Rocket Scientist"), new CoreCompetency("Science"));

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        assertEquals(testJob.toString().indexOf(lineSeparator()), 0);
        assertEquals(testJob.toString().lastIndexOf(lineSeparator()), testJob.toString().length() - 1);
    }

    @Test
    public void testToStringContainsAllLabels() {

        assertTrue(testJob.toString().contains("ID:"));
        assertTrue(testJob.toString().contains("Name:"));
        assertTrue(testJob.toString().contains("Employer:"));
        assertTrue(testJob.toString().contains("Location:"));
        assertTrue(testJob.toString().contains("Position Type:"));
        assertTrue(testJob.toString().contains("Core Competency:"));
    }

    @Test
    public void testFieldsOnNewLine() {
        String[] splitTestJob = testJob.toString().trim().split("\n");
        assertTrue(splitTestJob[0].contains("ID:"));
        assertTrue(splitTestJob[1].contains("Name:"));
        assertTrue(splitTestJob[2].contains("Employer:"));
        assertTrue(splitTestJob[3].contains("Location:"));
        assertTrue(splitTestJob[4].contains("Position Type:"));
        assertTrue(splitTestJob[5].contains("Core Competency:"));

    }

    public HashMap<String, String> finalSplitString(Job testJob) {
        String[] splitTestJob = testJob.toString().trim().split(":");
        ArrayList<String> stringTestJob = new ArrayList<>();
        ArrayList<String> stringKeys = new ArrayList<>();
        ArrayList<String> stringValues = new ArrayList<>();
        for (String s : splitTestJob) {
            String[] holder = s.split("\n");
            for (String string : holder) {
                stringTestJob.add(string.trim());
            }
        }
        HashMap<String, String> stringMap = new HashMap<>();
        stringMap.put(stringTestJob.get(0),stringTestJob.get(1));
        stringMap.put(stringTestJob.get(2),stringTestJob.get(3));
        stringMap.put(stringTestJob.get(4),stringTestJob.get(5));
        stringMap.put(stringTestJob.get(6),stringTestJob.get(7));
        stringMap.put(stringTestJob.get(8),stringTestJob.get(9));
        stringMap.put(stringTestJob.get(10),stringTestJob.get(11));

        return stringMap;
    }

    @Test
    public void testToStringContainsCorrectValuesAfterLabels() {

        HashMap<String, String> finalStringTestJob = finalSplitString(testJob);

        assertEquals(finalStringTestJob.get("ID"), String.valueOf(testJob.getId()));
        assertEquals(finalStringTestJob.get("Name"), testJob.getName());
        assertEquals(finalStringTestJob.get("Employer"), testJob.getEmployer().toString());
        assertEquals(finalStringTestJob.get("Location"), testJob.getLocation().toString());
        assertEquals(finalStringTestJob.get("Position Type"), testJob.getPositionType().toString());
        assertEquals(finalStringTestJob.get("Core Competency"), testJob.getCoreCompetency().toString());
    }

    @Test
    public void testEmptyFieldToStringReturnsDataNotAvailable() {

        Job noEmployer = new Job("Remote Job", new Employer(), new Location("Pawnee"), new PositionType("Computer stuff"), new CoreCompetency("Technology"));
        HashMap<String, String> finalSplitNoEmployer = finalSplitString(noEmployer);
        Job noLocation = new Job("Remote Job", new Employer("Self"), new Location(), new PositionType("Computer stuff"), new CoreCompetency("Technology"));
        HashMap<String, String> finalSplitNoLocation = finalSplitString(noLocation);
        Job noPositionType = new Job("Remote Job", new Employer("Self"), new Location("Pawnee"), new PositionType(), new CoreCompetency("Technology"));
        HashMap<String, String> finalSplitNoPositionType = finalSplitString(noPositionType);
        Job noCoreCompetency = new Job("Remote Job", new Employer("Self"), new Location("Pawnee"), new PositionType("Computer stuff"), new CoreCompetency());
        HashMap<String, String> finalSplitNoCoreCompetency = finalSplitString(noCoreCompetency);

        assertEquals(finalSplitNoEmployer.get("Employer"), "Data not available");
        assertEquals(finalSplitNoLocation.get("Location"), "Data not available");
        assertEquals(finalSplitNoPositionType.get("Position Type"), "Data not available");
        assertEquals(finalSplitNoCoreCompetency.get("Core Competency"), "Data not available");

    }

}
