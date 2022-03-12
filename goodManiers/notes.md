# Scala - notes

## The diffrences between var and val

var stands for variable, it is mutable, val stands for value, and it is immutable.

### Advantages of immutable state:
Programs are safe from concurrency incosistency in exchange from some additional memory alocation.

## Any type:
Any is the root of the class hierarchy - can be assigned to any value

## The symbol ???
One  of the most usefull feature. It's placeholder for future code - it tells compiler that its implementation will be added later. When using the symbol `???`, the function should have explicit return type. Compiler doesn't have much information, so it can struggle to infer the correct one. Being explicit can also help remind on what intention was and what implementation should return.
The symbol ??? is a useful tool when designing how the different components of program interact. It allows to focus on your code’s high-level structure rather than on implementation details.
Starting with an overall design rather than a detailed implementation is an excellent practice to develop programs that are easy to use, maintain, and understand


## Scala collection class:
There are 3 mainly categories:
1) Sequence
2) Map
3) Set

### Sequence:
Linear collection of elements, it may be indexed or linear - linked list
### Map:
Key - value data structure
### Set:
Sequence of elements without duplicates 

### The diffrences Seq and List:

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

## String interpolation
`id"text0${expr1}text1 ... ${expN}textN"`
### In this code:
* id = is a name of string interpolation method.
* The textN = pieces are string constants in the input(preinterpolated) string.
* The exprN = pieces are the expressions in the input string that are written
with the $expr or ${expr} syntax.

After compile the id code, the compiler translates it into code like this:
`StringContext("text0", "text1", ..., "textN").id(expr1, ...,exprN)`

## Scala can be lazy:
Scala has lazy vals, whose initializers are not evaluated unless and until the val is used. Lazy vals may be used as method local variables.
```
def doing(i: => Int): Something = {
  //        ^^^^^^ by-name parameter syntax
  lazy val ii = i
  // Rest of method uses ii, not i
}
```
### LazyList
Lazy structures are computed when they are needed

#### example:
file:`scala4.scala`, function : `getRandomString`.

Random.alphanumeric returns a `LazyList`, so have to use
`take(n).mkString` to get the first n characters from the stream. If only call `Random.alphanumeric.take(n)` it returns as result : `LazyList[Char] = LazyList(<notcomputed>)`
So have to call a method like `mkString` to force a string result.

## The diffrence between `trait` and `abstract class`:
Scala's `trait` works as Java's interface, it can have definition of functions' heads, however it can't have functions implementations.

`abstract class` also can have this property by using keyword `abstract` in function head definition. But also it can have normal functions with their implementations. Abstract class force subclasses to its own implementaion of `abstract` method.

Class can be extended by MULTIPLE `traits`, but interhait only one class