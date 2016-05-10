package Utils;

import Relationship.GenericRelation;
import Relationship.IGenericRelation;
import Relationship.IRelation;
import Relationship.SpecificRelation;

/**
 * Utility Class to deal with relation
 */
public class RelationUtility {
    public static IGenericRelation parseToGenericRelation(String relation) {
        relation = relation.toUpperCase();
        try {
            return GenericRelation.valueOf(relation);
        } catch (IllegalArgumentException e) {
            return SpecificRelation.valueOf(relation).getGenericRelation();
        }
    }

    public static IRelation parseToRelation(String relation) {
        relation = relation.toUpperCase();
        try {
            return GenericRelation.valueOf(relation);
        } catch (IllegalArgumentException e) {
            return SpecificRelation.valueOf(relation);
        }
    }
}
