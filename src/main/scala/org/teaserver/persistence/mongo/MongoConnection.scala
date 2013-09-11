package org.teaserver.persistence.mongo

import java.util.Properties
import org.teaserver.persistence.DBConnection
import scala.util.parsing.json.JSONObject

class MongoConnection(config: Properties) extends DBConnection {

  private def connect = {}

  def insert(request: JSONObject) {}

  def update(request: JSONObject) {}

  def delete(request: JSONObject) {}

  def get(request: JSONObject): JSONObject = null

  def query(request: JSONObject): List[JSONObject] = null

  def createTable(db: String, tabName: String, columns: List[JSONObject]) {}

  def dropTable(db: String, tabName: String) {}

  def createIndex(db: String, tabName: String, indexName: String, properties: JSONObject) {}

  def dropIndex(db: String, tabName: String, indexName: String) {}
}
