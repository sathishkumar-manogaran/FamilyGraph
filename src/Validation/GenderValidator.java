package Validation;

import Graph.FamilyGraph;
import Graph.Person;
import Relationship.GenericRelation;
import Relationship.IGenericRelation;
import Relationship.ISpecificRelation;
import Relationship.SpecificRelation;

/**
 * Class to validate Gender criteria for a relation
 */
public class GenderValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidatorInChain(Validator validator) {
        this.nextValidator = validator;
    }

    @Override
    public boolean validate(Person p1, IGenericRelation genericRelation, Person p2, int relationLevel, FamilyGraph family) {
        boolean isValid;
        switch ((GenericRelation) genericRelation) {
            case SPOUSE:
                isValid = (p1.isGenderMale() != p2.isGenderMale());
                break;
            default:
                isValid = true;
        }
        return (nextValidator == null) ? isValid : isValid && nextValidator.validate(p1, genericRelation, p2, relationLevel,
                family);
    }

    @Override
    public boolean validate(Person p1, ISpecificRelation specificRelation, Person p2, int relationLevel, FamilyGraph family) {
        boolean isValid = (specificRelation.isRelationMale() == p1.isGenderMale());

        switch ((SpecificRelation) specificRelation) {
            case HUSBAND:
            case WIFE:
                isValid &= (p1.isGenderMale() != p2.isGenderMale());
        }
        return (nextValidator == null) ? isValid : isValid && nextValidator.validate(p1, specificRelation, p2,
                relationLevel, family);
    }
}
