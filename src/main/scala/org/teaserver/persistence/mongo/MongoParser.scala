package org.teaserver.persistence.mongo

import org.teaserver.persistence.DBParser
import scala.util.parsing.json.JSONObject
import com.mongodb.casbah.commons.MongoDBObject

class MongoParser(json: JSONObject) extends DBParser[MongoDBObject] {
  def parse(obj: JSONObject): MongoDBObject = {
    null
  }

  abstract def parseBack(obj: MongoDBObject): JSONObject = {
    null
  }
}
