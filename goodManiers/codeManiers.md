# Scala good code maniers:

## The diffrences between var and val

var stands for variable, it is mutable, val stands for value, and it is immutable.

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

## The diffrences Seq and List

Seq is Java equivalent for List, List is Java equivalent for LinkedList.

Seq is based on trait. Seq is an iterable structure with order of elements. Sequences provide a method apply() for indexing, ranging from 0, up to length of sequence. Subclasses that use Seq:
* IndexesSeq:
    * Vector
    * Range
    * Numeric Range
    * String
* LinearSeq:
    * List
    * Steam
    * Queue
    * Stack

Scala's List is abstract class, that is extended by Nil and ::. So in Scala List is implementation. It use LIFO access pattern. List is immuatable, also is highly optimised by compiler and library. It is FUNDAMENTAL data type - data structure in functional programming. However it has some limitation in parallel programming - in that case better to use Vector

## How choose the right sequence?
When it's time to choose the important things to consider are:
* should be indexes and have rapid access or work as linked list
* should be muttable or immutable 

| Type/category  | Immutable | Mutable |
| ------------- |:-------------:|:-------------:|
| Indexed     | Vector     | ArrayBuffer      |
| Linear      | List     | ListBuffer     |

List and Vector are used in functional paradigm, ArrayBuffer and ListBuffer with imperative style.