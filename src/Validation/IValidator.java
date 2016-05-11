package Validation;

import Graph.FamilyGraph;
import Graph.Person;
import Relationship.IGenericRelation;
import Relationship.ISpecificRelation;

/**
 * Interface to abstract Validators
 */
public interface IValidator {
    void setNextValidatorInChain(IValidator validator);

    boolean validate(Person p1, IGenericRelation genericRelation, Person p2, int relationLevel, FamilyGraph family);

    boolean validate(Person p1, ISpecificRelation specificRelation, Person p2, int relationLevel, FamilyGraph family);
}
