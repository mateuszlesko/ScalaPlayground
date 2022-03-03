# Scala good code maniers:

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