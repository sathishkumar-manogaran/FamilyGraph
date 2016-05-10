package Validation;

import Graph.Person;
import Relationship.GenericRelation;
import Relationship.SpecificRelation;
import Software.SoftwareTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test GenderValidator
 */
public class GenderValidatorTest extends SoftwareTest {

    @Before
    public void init() {
        validator = new GenderValidator();
    }

    @Test
    public void validate() {
        Person p1 = family.getPersonById("1");
        Person p2 = family.getPersonById("8");
        Assert.assertTrue(validator.validate(p1, GenericRelation.SPOUSE, p2, 0, null));
    }

    @Test
    public void validate1() {
        Person p1 = family.getPersonById("2");
        Person p2 = family.getPersonById("8");
        Assert.assertFalse(validator.validate(p1, GenericRelation.SPOUSE, p2, 0, null));
    }

    @Test
    public void validate2() {
        Person p1 = family.getPersonById("1");
        Person p2 = family.getPersonById("8");
        Assert.assertTrue(validator.validate(p1, SpecificRelation.WIFE, p2, 0, null));
    }

    @Test
    public void validate3() {
        Person p1 = family.getPersonById("1");
        Person p2 = family.getPersonById("2");
        Assert.assertFalse(validator.validate(p1, SpecificRelation.BROTHER, p2, 0, null));
    }

    @Test
    public void validate4() {
        Person p1 = family.getPersonById("1");
        Person p2 = family.getPersonById("2");
        Assert.assertTrue(validator.validate(p1, SpecificRelation.SISTER, p2, 0, null));
    }

}