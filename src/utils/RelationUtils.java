/*
 * Copyright (c) 2016, Gopal S Akshintala 
 * This source code is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * http://creativecommons.org/licenses/by-sa/4.0/
 */

package utils;

import relationship.GenericRelation;
import relationship.IGenericRelation;
import relationship.IRelation;
import relationship.SpecificRelation;

/**
 * Utility Class to deal with relation
 */
public class RelationUtils {
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
