/*
 * Copyright (c) 2016, Gopal S Akshintala 
 * This source code is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * http://creativecommons.org/licenses/by-sa/4.0/
 */

package relationship;

/**
 * Class representing Specific relations
 */
public enum SpecificRelation implements ISpecificRelation {
    HUSBAND(true),
    WIFE(false),

    FATHER(true),
    MOTHER(false),

    SON(true),
    DAUGHTER(false),

    GRANDFATHER(true),
    GRANDMOTHER(false),

    GRANDSON(true),
    GRANDDAUGHTER(false),

    BROTHER(true),
    SISTER(false),

    UNCLE(true),
    AUNT(false),

    NEPHEW(true),
    NIECE(false),

    COUSIN(null);

    private final Boolean isRelationMale;
    private IGenericRelation IGenericRelation;

    SpecificRelation(Boolean isRelationMale) {
        this.isRelationMale = isRelationMale;
    }

    @Override
    public Boolean isRelationMale() {
        return isRelationMale;
    }

    @Override
    public IGenericRelation getGenericRelation() {
        return this.IGenericRelation;
    }

    @Override
    public void setGenericRelation(IGenericRelation IGenericRelation) {
        this.IGenericRelation = IGenericRelation;
    }
}
