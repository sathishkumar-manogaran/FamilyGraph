package graph;

import org.junit.Assert;
import org.junit.Test;
import software.SoftwareTest;

/**
 * Class to test ConnectionEdge
 */
public class ConnectionEdgeTest extends SoftwareTest {
    @Test
    public void testToString() {
        String expected = "(7)Lakshmi is GREAT GREAT GRANDMOTHER of (6)Pranavi RelationLevel: 4\n";
        System.out.println(new ConnectionEdge("7", "GRANDPARENT", "6", 4, family));
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testToString1() {
        String expected = "(6)Pranavi is GREAT GREAT GRANDDAUGHTER of (7)Lakshmi RelationLevel: -4\n";
        System.out.println(new ConnectionEdge("6", "GRANDCHILD", "7", -4, family));
        Assert.assertEquals(expected, outContent.toString());
    }
}