

object Scala4 
{
    //create own extension that capslock string
    extension(sc:StringContext)
        def caps(args:Any*) : String = {
        val strings : Iterator[String] = sc.parts.iterator
        val expressions : Iterator[Any] = args.iterator

        val sb = StringBuilder(strings.next.trim)
        while strings.hasNext do
            sb.append(expressions.next.toString)
            sb.append(strings.next)
        
        sb.toString.split(" ").map(_.trim).map(_.capitalize).mkString(" ")
        }
    end extension

    extension(sc:StringContext)
        def toList(args:Any*) : List[String] = {
            val strings : Iterator[String] = sc.parts.iterator
            val expressions : Iterator[Any] = args.iterator
            val sb = StringBuilder(strings.next.trim)
            while strings.hasNext do
                sb.append(expressions.next.toString)
                sb.append(strings.next)
            
            sb.toString.split(" ").toList
        }
    end extension
    
    //see in notes how it works!
    def getRandomString(n:Int): String = scala.util.Random.alphanumeric.take(n).mkString

    def getRandomSequence(n:Int) : String = {
        val rand = scala.util.Random
        val randSeq = for i <-0 to rand.nextInt(n) yield rand.nextPrintableChar
        randSeq.mkString
    }

    def play() : Unit = {
        println(caps"a b c d")
        println(toList"a b c d")
        println(s"Random string #1: ${getRandomString(10)}")
        println(s"Random string #2: ${getRandomString(10)}")
        println(s"Random sequence: ${getRandomSequence(10)}")


    }
} 