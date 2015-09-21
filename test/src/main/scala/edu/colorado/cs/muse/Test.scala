package edu.colorado.cs.muse

import edu.colorado.cs.muse.utils.ReverseMe

object Test {

  def readFile(name: String): String = {
    val handle = io.Source.fromFile(name)
    val data   = handle.mkString

    handle.close
    data
  }

  def main(args: Array[String]) {

    val r    = new ReverseMe()
    val data = readFile(args(0))

    println(s"First Argument: ${data}") 
    println(s"Reversed      : ${r.reverse(data)}")
  }

}
