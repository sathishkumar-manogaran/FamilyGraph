package Validation;

import Graph.FamilyGraph;
import Graph.Person;
import Relationship.GenericRelation;
import Relationship.IGenericRelation;
import Relationship.ISpecificRelation;

/**
 * Class to validate age criteria for a Relation
 */
public class AgeValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidatorInChain(Validator validator) {
        this.nextValidator = validator;
    }

    @Override
    public boolean validate(Person p1, IGenericRelation genericRelation, Person p2, int relationLevel, FamilyGraph family) {
        boolean isValid;
        switch ((GenericRelation) genericRelation) {
            case PARENT:
            case KIN:
            case GRANDPARENT:
                isValid = (p1.getAge() > p2.getAge());
                break;
            case CHILD:
            case NIBLING:
            case GRANDCHILD:
                isValid = p1.getAge() < p2.getAge();
                break;
            default:
                isValid = true;
        }
        return (nextValidator == null) ? isValid : isValid && nextValidator.validate(p1, genericRelation, p2, relationLevel,
                family);
    }

    @Override
    public boolean validate(Person p1, ISpecificRelation specificRelation, Person p2, int relationLevel, FamilyGraph family) {
        return this.validate(p1, specificRelation.getGenericRelation(), p2, relationLevel, family);
    }
}
