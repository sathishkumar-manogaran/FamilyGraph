/*
 * Copyright (c) 2016, Gopal S Akshintala
 * This source code is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 */

package relationship;

/**
 * Interface to abstract methods related to Generic relations
 */
public interface IGenericRelation extends IRelation {
    ISpecificRelation getFemaleRelation();

    ISpecificRelation getMaleRelation();

    ISpecificRelation getGenderSpecificRelation(boolean isMale);

    IGenericRelation getReverseRelation();

    IGenericRelation getAlternateRelation();

    int getRelationLevel();

    IGenericRelation getNextGenericRelation(IGenericRelation curRelation);
}
