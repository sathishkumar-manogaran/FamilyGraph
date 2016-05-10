# Family Graph

### Features
1.  Display Family Tree
2.  Display Shortest Relation Chain
3.  Display Members from Generation Level
4.  Display Family Members in Ascending order of Age
5.  Display Family Members in Descending order of Age
6.  Display Male Family Members
7.  Display Female Family Members
8.  Display Aggregate Relation
9.  Display Persons by Relation
10. Display Persons Related to someone with Relation

### Design Decisions
- Family is represented as a Graph, with Persons as Nodes and Relations as Edges.
- Edge is called 'Connection' and it holds From Person, To Person, Generic Relation and Relation Level.
- The system can support both Generic and Specific type of relations. The system shall assign proper relation based on
  Gender, client doesn't have to worry about sending a specific relation.
- Relation level of a connection represents the difference of levels above or below the persons. 
- Template pattern followed for Relations, so that every relations follows a stipulated template of methods.
- Graph stores only generic relations and they are converted back to specific relations based on gender.
- Chain of Responsibilities pattern used for Validation.
- Violated 'Law of Demeter' to reduce wrapping and complexity. Eg: `edge.relation().getGenericRelation()`
- Violated SRP for DRY at places like `traverseFamilyGraph`

- Most of the relations come in pairs, as one is reverse of the other. They are coupled together, and one depends on 
another to get reverse relation in `getReverseRelation()`. Same is followed for Specific relations in 
`getGenericRelation()`;
- Using enum functions instead of maintaining a Map, because it enforces to add required logic for every new 
generic relation and also to avoid adding a new entity at 2 places (enum and map).
- Every relation holds its own state of relation level and methods to 

### Assumptions/Limitations
- PARENT, SIBLING, CHILD are direct relations and KIN, COUSIN, NIBLING are indirect relations.
So, when there is no direct connection between two persons, we assume a inderect relation
between them. For example, KIN of a CHILD is treated as COUSIN, instead of SIBLING.
- COUSIN is both generic and specific relation.

### Glossary
- KIN: Generic gender neutral word chosen for UNCLE and AUNT.
- NIBLING: Generic gender neutral word chosen for NEPHEW and NIECE