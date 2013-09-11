package org.teaserver.persistence

import scala.util.parsing.json.JSONObject

trait DBParser[T] {
  abstract def parse (obj: JSONObject) : T

  abstract  def parseBack (obj: T) : JSONObject
}
