package Validation;

import Graph.ConnectionEdge;
import Graph.FamilyGraph;
import Graph.Person;
import Relationship.GenericRelation;
import Relationship.IGenericRelation;
import Relationship.ISpecificRelation;

/**
 * Class to validate Possible Relationship
 */
public class RelationshipValidator implements IValidator {
    private IValidator nextValidator;

    @Override
    public void setNextValidatorInChain(IValidator validator) {
        this.nextValidator = validator;
    }

    @Override
    public boolean validate(Person p1, IGenericRelation genericRelation, Person p2, int relationLevel, FamilyGraph family) {
        // It's Ok to compare generic relations as it has already passed the gender validation.
        ConnectionEdge connection = family.getConnection(p1, p2);
        if (connection == null) return true;
        boolean isRelationLevelValid;
        switch ((GenericRelation) genericRelation) {
            case GRANDPARENT:
                isRelationLevelValid = relationLevel >= connection.getRelationLevel();
                break;
            case GRANDCHILD:
                isRelationLevelValid = relationLevel <= connection.getRelationLevel();
                break;
            default:
                isRelationLevelValid = relationLevel == connection.getRelationLevel();
        }
        return isRelationLevelValid && (genericRelation.equals(connection.relation())
                || genericRelation.getAlternateRelation().equals(connection.relation()));
    }

    @Override
    public boolean validate(Person p1, ISpecificRelation specificRelation, Person p2, int relationLevel, FamilyGraph family) {
        return this.validate(p1, specificRelation.getGenericRelation(), p2, relationLevel, family);
    }
}
