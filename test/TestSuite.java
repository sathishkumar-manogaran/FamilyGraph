import Graph.ConnectionEdgeTest;
import Graph.FamilyGraphTest;
import Loader.FileLoaderServiceTest;
import Relationship.GenericRelationTest;
import Relationship.SpecificRelationTest;
import Validation.AgeValidatorTest;
import Validation.GenderValidatorTest;
import Validation.RelationshipValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite to aggregate all tests
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConnectionEdgeTest.class,
        FamilyGraphTest.class,
        FileLoaderServiceTest.class,
        GenericRelationTest.class,
        SpecificRelationTest.class,
        AgeValidatorTest.class,
        GenderValidatorTest.class,
        RelationshipValidatorTest.class
})

public class TestSuite {

}
