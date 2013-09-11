package org.teaserver.persistence

import scala.util.parsing.json.JSONObject

trait DBConnection {
  def insert(request: JSONObject)

  def update(request: JSONObject)

  def delete(request: JSONObject)

  def get(request: JSONObject) : JSONObject

  def query(request: JSONObject) : List[JSONObject]

  def createTable(db: String, tabName: String, columns: List[JSONObject] = null)

  def dropTable(db: String, tabName: String)

  def createIndex(db: String, tabName: String, indexName: String, properties: JSONObject = null)

  def dropIndex(db: String, tabName: String, indexName: String)

  def dataBases = List[String]

  def entities(database: String) = List[String]

}
