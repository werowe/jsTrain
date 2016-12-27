import scala.io.Source
 

val jssFile = Source.fromFile("/home/walker/Documents/jss/data.csv").getLines().toList

import java.io._

val pw = new PrintWriter(new File("/home/walker/Documents/jss/data.svm" ))

for (lines <- jssFile) {
    var line = lines.split(",")
    pw.write(line (0) + " 1:" + line(1) + " 2:" + line(2) + "\n")
}

pw.close()
