package Software;

import Graph.FamilyGraph;
import Loader.FileLoaderService;
import Loader.LoaderService;
import Printer.ConsolePrintService;
import Printer.PrintService;
import Validation.AgeValidator;
import Validation.GenderValidator;
import Validation.RelationshipValidator;
import Validation.Validator;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Test Class holding setUp logic and is inherited by all Test Classes.
 */
public class SoftwareTest {

    protected static ByteArrayOutputStream outContent;
    protected static FamilyGraph family;
    protected static LoaderService loader;
    protected static PrintService printer;
    protected static Validator validator;

    private static Validator setUpValidation() {
        Validator genderValidator = new GenderValidator();
        Validator ageValidator = new AgeValidator();
        Validator relationShipValidator = new RelationshipValidator();

        genderValidator.setNextValidatorInChain(ageValidator);
        ageValidator.setNextValidatorInChain(relationShipValidator);

        return genderValidator;
    }

    @Before
    public void setUp() {
        validator = setUpValidation();
        family = new FamilyGraph(validator);
        try {
            loader = new FileLoaderService(new BufferedReader(new FileReader(new File("res//MyFamily"))));
            loader.loadFamily(family);
            printer = new ConsolePrintService(System.out);

            outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
        } catch (IOException e) {
            System.out.println("Exception while loading family from file: " + e.getMessage());
        }
    }

}
