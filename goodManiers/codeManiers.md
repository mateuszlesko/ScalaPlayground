# Scala good code maniers:

## While loop as antipattern:
`while` loop is a part of langauge, but it's rarely used and often consider as antipattern. `while` loop oparate on mutable state - it keep track how value evolves, and stop once a predicate  is respected. Scala discourages the use of mutability

Alternatives: dedicated functions such as foreach and map 

## Why use ::: over ++?

1) efficiency:

a ::: b ::: c is much faster, because ::: is right associative. The statement is parsed as 
a ::: (b ::: c), which is faster than (a:::b):::c - this requires more O(n) steps

BETTER aproach:
```
List(x, y, z).flatten
```

2) type safety:

Operator ::: can only concat Lists, ++ are able to concat list and anything else to it

## How choose the right sequence?
When it's time to choose the important things to consider are:
* should be indexes and have rapid access or work as linked list
* should be muttable or immutable 

| Type/category  | Immutable | Mutable |
| ------------- |:-------------:|:-------------:|
| Indexed     | Vector     | ArrayBuffer      |
| Linear      | List     | ListBuffer     |

List and Vector are used in functional paradigm, ArrayBuffer and ListBuffer with imperative style.