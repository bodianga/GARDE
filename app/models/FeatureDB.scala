package models

case class FeatureDB(id : Int, path : String, name : String, description : String, backgroundAsJson : Option[String] = None, branchId : Int, language : Option[String] = None, keyword : Option[String])